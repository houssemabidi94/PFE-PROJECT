import { LoginPage } from './login.po';

import { browser, protractor } from 'protractor';
import { HomePage } from '../home/home.po';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};


describe('Login page', () => {
  let page: LoginPage;
  let publicPage: HomePage;

  const wrongCredentias = {
    email: 'wrongname',
    password: 'wrongpasswd'
  };

  const collabCredentials={
    email: 'collab',
    password: 'collab'
  };

  beforeEach(() => {
    page = new LoginPage();
    publicPage = new HomePage();
  });

  it('lorsque l\'utilisateur essaie de se connecter avec des informations d\'identification erronées, il doit rester sur la page «connexion» et voir la notification d\'erreur', () => {
    page.fillCredentials(wrongCredentias);
    expect(page.getPageTitleText()).toEqual('Login');
    expect(page.getErrorMessage()).toEqual('les informations d\'identification invalides');
  });

  it('lorsque la connexion est réussie - il doit rediriger vers la page "Home" par défaut', () => {
    page.clearValues();
    page.fillCredentials(collabCredentials);
    expect(publicPage.getPageTitleText()).toEqual('Evaluation des objectifs individuel');
  });
});