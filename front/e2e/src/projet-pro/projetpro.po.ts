import { element, by, browser } from 'protractor';

export class projetPro {

    addProjetFormation(){
        var elem = element(by.id('next3'));
        browser.actions().mouseMove(elem).click().perform();

        element(by.id('projet')).sendKeys("new projet");

        element(by.id('formation')).sendKeys("new Formation");

        var button = element(by.id('save2'));
        browser.actions().mouseMove(button).click().perform();

}

getSuccessMsg(){
    return element(by.id('successprojet')).getText();
}
}