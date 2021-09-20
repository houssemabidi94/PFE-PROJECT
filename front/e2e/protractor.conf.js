// @ts-check
// Protractor configuration file, see link for more information
// https://github.com/angular/protractor/blob/master/lib/config.ts

const { SpecReporter } = require('jasmine-spec-reporter');

/**
 * @type { import("protractor").Config }
 */

 
exports.config = {
  allScriptsTimeout: 11000,
suites:{

protected : './src/protected/protected.e2e-spec.ts',
login :     './src/login/login.e2e-spec.ts',
autoeval :     './src/auto-eval/autoeval.e2e-spec.ts',
evalManager : './src/eval-manager/evalmanager.e2e-spec.ts',
teamEvaluate : './src/team-evaluate/teamevaluate.e2e-spec.ts',
newobj : './src/new-objectifs/newobjectif.e2e-spec.ts',
evalcomp : './src/eval-competences/evalcomp.e2e-spec.ts',
projetpro : './src/projet-pro/projetpro.e2e-spec.ts',
cloture : './src/cloture/cloture.e2e-spec.ts',
},
  capabilities: {
    browserName: 'chrome',
  },
  directConnect: true,
  baseUrl: 'http://localhost:4200/',
  framework: 'jasmine',
  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 1440000,
    print: function() {}
  },
  onPrepare() {
    
    browser.driver.manage().window().maximize();

    require('ts-node').register({
      project: require('path').join(__dirname, './tsconfig.json')
    });

    jasmine.getEnv().addReporter(new SpecReporter({
      spec: {
        displayStacktrace: true
      }
    }));
  }
};