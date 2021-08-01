import { ProtectedPage } from './protected.po';
import { LoginPage } from '../login/login.po';
import { browser, protractor } from 'protractor';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe('La protection de l application', () => {
  let page: ProtectedPage;
  let loginPage: LoginPage;
  beforeEach(() => {
    page = new ProtectedPage();
    loginPage = new LoginPage();
  });

  it('lorsque l utilisateur non authentifié tente d accéder à la page "Home", il doit rediriger vers "Login"', () => {
    page.navigateTo();
    expect(loginPage.getPageTitleText()).toEqual('Login');
  });
});
