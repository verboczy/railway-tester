/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test;

import hu.bme.mit.modes3.test.TestLanguageStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class TestLanguageStandaloneSetup extends TestLanguageStandaloneSetupGenerated {
  public static void doSetup() {
    TestLanguageStandaloneSetup _testLanguageStandaloneSetup = new TestLanguageStandaloneSetup();
    _testLanguageStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
