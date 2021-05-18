import { HomePage } from './home.po';
import { LoginPage } from '../login/login.po';
import { browser, protractor } from 'protractor';

var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Home page', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
  });

  it('when user browses to our app he should see the default “Login” screen', () => {
    page.navigateTo();
    expect(page.getPageTitleText()).toEqual('Login');
  });
});
