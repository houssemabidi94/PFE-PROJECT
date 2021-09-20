import { browser, element, by } from 'protractor';

export class evalManager {

    navigateTo() {
        var elem = element(by.id('navbar'));
        browser.actions().mouseUp(elem).perform();
        browser.get('/evaluation');
      }
autoEvaluateManager(){
  var elem =  element(by.id('autoEval'));
  browser.actions().mouseMove(elem).click().perform();
}

chooseCollab(){
    var elem =  element(by.id('eip'));
    browser.actions().mouseMove(elem).click().perform();
    var collab = element.all(by.id('collab')).get(0);
    browser.actions().mouseMove(collab).click().perform();
    
}
eipPage(){
    return element(by.css('app-root h5')).getText();
}
}