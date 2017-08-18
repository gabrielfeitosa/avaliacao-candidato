var FormularioPage = function () {

    var nome = element(by.model('ctrl.candidato.nome'));
    var email = element(by.model('ctrl.candidato.email'));
    var submit = element(by.id('btnSubmit'));
    var mensagem = element(by.id('mensagem'));
    var skills = element.all(by.repeater('skill in $ctrl.skills'));
    var self = this;

    self.navigateTo = function () {
        browser.get('http://webe2e:8080/');
    };

    self.getElementMensagemErro = function (campo, tipo) {
        return element(by.id(campo + '-erro-' + tipo));
    }

    self.preencherCandidato = function (candidato) {
        nome.sendKeys(candidato.nome);
        email.sendKeys(candidato.email);
    }

    self.setNome = function (n) {
        if (!n) {
            nome.clear()
        } else {
            nome.sendKeys(n);
        }
    }

    self.setEmail = function (e) {
        if (!e) {
            email.clear();
        } else {
            email.sendKeys(e);
        }
    }

    self.getBotaoSubmit = function () {
        return submit;
    }

    self.getMensagem = function () {
        return mensagem.getText();
    }

    self.selecionarRating = function (tipo, valor) {
        var seletor = '#rating-'+tipo+'>span';
        element(by.css(seletor+' i[title="'+valor+'"]')).click();
        return element(by.css(seletor)).getAttribute('aria-valuetext');
    }
};

module.exports = FormularioPage;
