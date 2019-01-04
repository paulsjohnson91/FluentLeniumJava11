package testpackage;

import org.fluentlenium.configuration.ConfigurationDefaults;

public class CustomConfigurationDefaults extends ConfigurationDefaults {

  @Override
  public String getBaseUrl() {
    return "http://www.google.co.uk";
  }
}