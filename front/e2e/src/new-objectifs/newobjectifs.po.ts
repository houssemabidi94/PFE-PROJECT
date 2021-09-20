import { element, by, browser } from 'protractor';

export class newObjectifs {

    addObjectif(){
        var elem = element(by.id('next'));
        browser.actions().mouseMove(elem).click().perform();

        element(by.id('newObj')).sendKeys("new Objectifs 1");

        var add = element(by.id('add'));
        browser.actions().mouseMove(add).click().perform();

        element.all(by.id('newObj')).get(1).sendKeys("new Objectifs 2");

        var del = element.all(by.id('del')).get(1);
        browser.actions().mouseMove(del).click().perform();

        var button = element(by.id('save'));
        browser.actions().mouseMove(button).click().perform();
    }

    getSuccessMsg(){
        return element(by.id('success2')).getText();
    }


}