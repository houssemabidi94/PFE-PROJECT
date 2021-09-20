import { browser, by, element, protractor } from 'protractor';

export class HomePage {


  navigateTo() {
    return browser.get('/'); // we can navigate to '/' for get pblic page since this is the default route
  }

  getPageTitleText() {
    return element(by.css('app-root h5')).getText();
  }
  logOut() {
    var elem = element(by.id('liste'));

    browser.actions().mouseUp(elem).click().perform();
    browser.actions().mouseDown(elem).click().perform();
    var elem2 = element(by.id('logout'));
    browser.actions().mouseMove(elem2).click().perform();

  }
}