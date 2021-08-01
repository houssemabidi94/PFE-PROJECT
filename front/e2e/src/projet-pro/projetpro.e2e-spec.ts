import { browser, protractor } from "protractor";
import { projetPro } from './projetpro.po';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Nouveau projet et formation', () => {
    let projet : projetPro;
  
  
    beforeEach(() => {
        projet = new projetPro();
    });
  
    it('le manager a réussie d ajouter des nouveaux projet et formation', () => {    
  
      projet.addProjetFormation();
      expect(projet.getSuccessMsg()).toEqual('Les projets sont ajoutés avec success !');
    });
  
  });
  