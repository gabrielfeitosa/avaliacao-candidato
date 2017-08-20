const FormularioPage = require('./formulario.po');

describe('>> Avaliação do Candidato', function () {

    var page = new FormularioPage();

    beforeEach(function () {
        page.navigateTo();
    });

    describe('>> Validar os campos obrigatórios', function () {

        it(' * Deve validar o nome obrigatório', function () {
            var element = page.getElementMensagemErro('nome', 'required');
            expect(element.isDisplayed()).toBeFalsy();
            page.setNome('Teste');
            page.setNome();
            expect(element.isDisplayed()).toBeTruthy();
            expect(element.getText()).toEqual('Campo obrigatório');
            expect(page.getBotaoSubmit().isEnabled()).toBeFalsy();
        });

        it(' * Deve validar o email obrigatório', function () {
            var element = page.getElementMensagemErro('email', 'required');
            expect(element.isDisplayed()).toBeFalsy();
            page.setEmail('teste@teste.com');
            page.setEmail();
            expect(element.isDisplayed()).toBeTruthy();
            expect(element.getText()).toEqual('Campo obrigatório');
            expect(page.getBotaoSubmit().isEnabled()).toBeFalsy();
        });

        it(' * Deve validar o pattern email', function () {
            var element = page.getElementMensagemErro('email', 'pattern');
            expect(element.isPresent()).toBeFalsy();
            page.setEmail('teste');
            expect(element.isDisplayed()).toBeTruthy();
            expect(element.getText()).toEqual('Formato de email inválido');
            expect(page.getBotaoSubmit().isEnabled()).toBeFalsy();
        });
    });

    describe('>> Validar seleção de skills', function () {
        it(' * Deve mudar a cor de acordo com o grau de conhecimento', function () {
            var skill = element(by.id('rating-HTML'));

            var dados = [
                {cor: 'warning', valores: [1, 2]},
                {cor: 'info', valores: [3, 4, 5, 6]},
                {cor: 'success', valores: [7, 8, 9, 10]}
            ];

            dados.forEach(function (dado) {
                dado.valores.forEach(function (valor) {
                    var elem = element(by.css('#rating-HTML>span i[title="'+valor+'"]'));
                    browser.actions().mouseMove(elem).perform();
                    expect(skill.getAttribute('class')).toContain(dado.cor);
                });
            });
        });
    });

    describe('>> Submeter o formulário', function () {

        it(' * Deve submeter o formulário com dados preenchidos para frontend', function () {
            var candidato = {
                nome: "Teste",
                email: "teste@teste.com"
            }
            page.preencherCandidato(candidato);
            expect(page.selecionarRating('HTML', 10)).toEqual('10');
            expect(page.selecionarRating('CSS', 7)).toEqual('7');
            expect(page.selecionarRating('JAVASCRIPT', 8)).toEqual('8');
            expect(page.selecionarRating('HTML', 9)).toEqual('9');
            expect(page.getBotaoSubmit().isEnabled()).toBeTruthy();
            page.getBotaoSubmit().click();
            expect(page.getMensagem()).toEqual('Enviado para avaliação!');
        });
    });
});
