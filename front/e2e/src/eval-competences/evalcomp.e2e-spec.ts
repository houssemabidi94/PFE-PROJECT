import { browser, protractor } from "protractor";
import { evalCompetence } from './evalcomp.po';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};

describe(' Evaluations Competence', () => {
  let evalComp : evalCompetence;

  beforeEach(() => {
    evalComp = new evalCompetence();
  });

  it('le manager a réussie d evaluations des competences', () => {    

    evalComp.evaluate();
        expect(evalComp.getSuccessMsg()).toEqual('Votre évaluation de compétence a été sauvgarder avec success !');
  });

});
