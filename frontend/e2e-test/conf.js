var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: 'tests-report/screenshots-'+Date.now()
});

exports.config = {
  framework: 'jasmine',
  specs: ['*.e2e.js'],
  capabilities: {
    browserName: 'chrome'
  },

  beforeLaunch: function() {
    return new Promise(function(resolve){
      reporter.beforeLaunch(resolve);
    });
  },
  onPrepare: function() {
    jasmine.getEnv().addReporter(reporter);
  },
  afterLaunch: function(exitCode) {
    return new Promise(function(resolve){
      reporter.afterLaunch(resolve.bind(this, exitCode));
    });
  }
}
