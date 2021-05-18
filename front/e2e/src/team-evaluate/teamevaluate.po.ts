import { element, by, browser } from 'protractor';

export class teamEvaluate {

getSuccessMsg(){
    return element(by.id('success')).getText();
}
goToEop(){
      browser.actions().mouseMove(element(by.id('submit'))).perform();
}
}
