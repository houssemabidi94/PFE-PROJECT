import { autoeval } from "../auto-eval/autoeval.po";
import { teamEvaluate } from './teamevaluate.po';
import { browser, protractor } from 'protractor';


var origFn = browser.driver.controlFlow().execute;
browser.driver.controlFlow().execute = function() {
  var args = arguments;

  // queue 100ms wait
  origFn.call(browser.driver.controlFlow(), function() {
    return protractor.promise.delayed(0);
  });

  return origFn.apply(browser.driver.controlFlow(), args);
};


describe('EIPs - page', () => {

    let autoEval : autoeval;
    let teamEval : teamEvaluate;

    beforeEach(() => {
        autoEval = new autoeval();
        teamEval = new teamEvaluate();
      });

    it('le manager a fait l evauluation du collaborateur avec succès ', () => {
    teamEval.goToEop();  
    autoEval.evaluate();
    expect(teamEval.getSuccessMsg()).toEqual('Votre évaluation a été sauvgarder avec success !');
      });
});