import { browser, element, by } from 'protractor';

export class autoeval {


    evaluations = [
		{ "id": 1, "designation": "Performance a ameliore" },
		{ "id": 2, "designation": "Zone de conformite" },
		{ "id": 3, "designation": "Objectif dépassé" },
		{ "id": 4, "designation": "Performance exceptionnelle" }
	];

gotoAutoEvalCollab(){
 
 var elem = element(by.id('navbar'));
 browser.actions().mouseUp(elem).perform();
 browser.get('/auto-evaluation');

}
getPageTitleText() {
    return element(by.css('app-root h5')).getText();
  }

  getSuccessText() {
    return element(by.id('success')).getText();
  }

  evaluate(){
  for(let i =0;i<1;i++){
   element.all(by.id('select')).get(i).click().then(() =>{
       element(by.css('.mat-option[ng-reflect-value="'+this.evaluations[i].designation+'"]')).click();
    });
    element.all(by.id('comm')).get(i).sendKeys("Commentaires "+(i+1));
}

browser.actions().mouseMove(element(by.id('submit'))).click().perform();
browser.actions().mouseMove(element(by.id('submit'))).perform();
}
}