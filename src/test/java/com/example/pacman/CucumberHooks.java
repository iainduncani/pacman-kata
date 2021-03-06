package com.example.pacman;
 
import java.util.Collection;
 
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.api.java.en.Then;
 
public final class CucumberHooks {
 
  private static final String TAG = "@important";
  private static boolean prevScenarioFailed = false;
  
  public static boolean wantsToQuit = false;
/*
  @Before
  public void quitIfRequested(Scenario scenario) {
    if (wantsToQuit)
      throw new RuntimeException("Cucumber wants to quit.");
  }
  
  @Then("^something bad$")
  public void quit() throws Throwable {
    throw new RuntimeException("Fail!");
  }
  
  @After
  public void after(Scenario s) throws Exception {
    // Tell Cucumber to quit after this scenario is done - if it failed.
    CucumberHooks.wantsToQuit = false == s.isFailed();
  }
  */
 
  @After
  public void watch_this_tagged_scenario(Scenario scenario) throws Exception {
    if (isTagged(scenario)) {
      boolean isFailed = scenario.isFailed();
      if (isFailed)
        prevScenarioFailed = isFailed;
    }
  }
 
  @Before
  public void quit_if_tagged_scenario_failed(Scenario scenario) {
    if (!isTagged(scenario) && prevScenarioFailed)
      throw new IllegalStateException("An important scenario has failed! Cucumber wants to quit.");
  }
 
  private boolean isTagged(Scenario scenario) {
    Collection<String> tags = scenario.getSourceTagNames();
    return tags.contains(TAG);
  }
}