import { browser, protractor } from "protractor";
import { newObjectifs } from './newobjectifs.po';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Nouveaux Objectifs', () => {
  let newObj : newObjectifs;


  beforeEach(() => {
    newObj = new newObjectifs();
  });

  it('le manager a réussie d ajouter des nouveaux objectifs', () => {    

    newObj.addObjectif();
    expect(newObj.getSuccessMsg()).toEqual('Les objectifs sont ajoutés avec success !');
  });

});
