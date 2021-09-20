import { browser, by, element } from 'protractor';

export class LoginPage {
  private credentias = {
    email: '',
    password: ''
  };

  navigateTo() {
    return browser.get('/login');
  }

  fillCredentials(credentias: any = this.credentias) {
    element(by.name('email')).sendKeys(credentias.email);
    element(by.name('password')).sendKeys(credentias.password);
    element(by.css('.btn-primary')).click();
  }
  clearValues() {
    element(by.name('email')).clear();
    element(by.name('password')).clear();
  }
  getPageTitleText() {
    return element(by.css('app-root h3')).getText();
  }

  getErrorMessage() {
    return element(by.css('.alert-danger')).getText();
  }
}
