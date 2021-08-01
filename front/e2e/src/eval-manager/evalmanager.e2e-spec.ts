import { LoginPage } from "../login/login.po";
import { protractor, browser } from 'protractor';
import { HomePage } from '../home/home.po';
import { basename } from 'path';
import { autoeval } from '../auto-eval/autoeval.po';
import { evalManager } from './evalmanager.po';



var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Evaluation Manager', () => {
  let loginpage: LoginPage;
let homep : HomePage;
let autoEval : autoeval;
let evalmanager : evalManager;


const managerCredentials={
    email: 'manager',
    password: 'manager'
  };

  beforeEach(() => {
    loginpage = new LoginPage();
    homep     = new HomePage();
    autoEval = new autoeval();
    evalmanager = new evalManager();
  });

  it('lorsque le manager a réussie sa connexion - il doit rediriger vers la page "Home" par défaut', () => {    
    homep.logOut();
    loginpage.fillCredentials(managerCredentials);
    expect(homep.getPageTitleText()).toEqual('Evaluation');
  });
  it('le manager a fait avec succès l auto evaluation ', () => {
    evalmanager.navigateTo();
    evalmanager.autoEvaluateManager();
    autoEval.evaluate();
    expect(autoEval.getSuccessText()).toEqual('Votre auto-évaluation a été sauvgarder avec success !');
      });

      it('le manager a bien choisie un collaborateur pour l évlauer ', () => {
        evalmanager.chooseCollab();
        expect(evalmanager.eipPage()).toEqual('Mon equipe EIPs');
          });
});
