import { browser, protractor } from "protractor";
import { autoeval } from './autoeval.po';
import { HomePage } from '../home/home.po';
import { LoginPage } from '../login/login.po';

var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};


describe('Auto Evaluation - page', () => {

    let autoEval : autoeval;
    let homep : HomePage;
    let loginpage: LoginPage;
    beforeEach(() => {
        autoEval = new autoeval();
        homep     = new HomePage();
        loginpage = new LoginPage();
      });

    it('le collaborateur a accéder avec succès la page auto evaluation ', () => {
    autoEval.gotoAutoEvalCollab();
    expect(autoEval.getPageTitleText()).toEqual('Evaluation des objectifs individuel');
      });
    it('le collaborateur a évaluer avec succès ses objectifs ', () => {
autoEval.evaluate();
expect(autoEval.getSuccessText()).toEqual('Votre auto-évaluation a été sauvgarder avec success !');
    });
});