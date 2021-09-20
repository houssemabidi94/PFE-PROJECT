import { element, by, browser } from 'protractor';

export class Cloture {

    addRemarque(){
        var elem = element(by.id('next4'));
        browser.actions().mouseMove(elem).click().perform();

        element(by.id('remarque')).sendKeys("new remarque");

        var button = element(by.id('saveremarque'));
        browser.actions().mouseMove(button).click().perform();

}
remarqueNewObj(){
    var elem =  element(by.id('feedback'));
    browser.actions().mouseMove(elem).click().perform();
    browser.sleep(1000);
    var collabo = element.all(by.id('collabo')).get(0);
    browser.actions().mouseMove(collabo).click().perform();

    element(by.id('remobj')).sendKeys("new remarque sur obj");

    var button = element(by.id('submit2'));
    browser.actions().mouseMove(button).click().perform();
    browser.sleep(1000);
}
getSuccessMsg(){
    return element(by.css('app-root h5')).getText();
}
getSuccessMsg2(){
    return element(by.id('successrem')).getText();
}

}