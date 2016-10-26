package hu.bme.mit.modes3.test.generator;

import hu.bme.mit.modes3.test.testLanguage.Model;

@SuppressWarnings("all")
public interface ITestGenerator {
  public abstract String generate(final Model model);
}
