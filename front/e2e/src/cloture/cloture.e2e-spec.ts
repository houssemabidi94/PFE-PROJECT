import { browser, protractor } from "protractor";
import { Cloture } from './cloture.po';



var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Cloture', () => {
    let cloture : Cloture;
  
  
    beforeEach(() => {
        cloture = new Cloture();
    });
  
    it('le manager a réussie de saisir remarque génerale', () => {    
  
      cloture.addRemarque();
      expect(cloture.getSuccessMsg()).toEqual('Evaluation');
    });
    it('le manager a réussie de saisir remarque sur les nouveaux obj', () => {    
  
      cloture.remarqueNewObj();
      expect(cloture.getSuccessMsg2()).toEqual('Les remarques des objectifs sont ajoutés avec success !');
    });
  });
  