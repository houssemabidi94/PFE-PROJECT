import { browser, element, by } from 'protractor';

export class evalCompetence {


    evaluations = [
		{ "id": 1, "designation": "Niveau 1" },
		{ "id": 2, "designation": "Niveau 2" },
		{ "id": 3, "designation": "Niveau 3" },
        { "id": 4, "designation": "Niveau 4" },
        { "id": 5, "designation": "Niveau 5" },
	];


    getSuccessMsg() {
    return element(by.id('success3')).getText();
  }

  evaluate(){
    var elem = element(by.id('next2'));
        browser.actions().mouseMove(elem).click().perform();

    element(by.id('select2')).click();

        browser.actions().mouseUp(element(by.id('submit2'))).perform();
        browser.actions().mouseDown(element(by.id('submit2'))).perform();
browser.actions().mouseMove(element(by.id('submit2'))).perform();
        

element.all(by.css('button[aria-label=\'Next page\']')).get(1).click();
element.all(by.css('button[aria-label=\'Previous page\']')).get(1).click();

  for(let i =0;i<3;i++){
   element.all(by.id('select2')).get(i).click().then(() =>{

      var niv = element(by.css('.mat-option[ng-reflect-value="1"]'));
      browser.actions().mouseMove(niv).perform();
      browser.actions().mouseMove(niv).click().perform();
    });
}
browser.actions().mouseUp(element(by.id('submit2'))).perform();
browser.actions().mouseDown(element(by.id('submit2'))).perform();
browser.actions().mouseMove(element(by.id('submit2'))).click().perform();

}


}