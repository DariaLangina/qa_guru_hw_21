package dlangina.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

  String app();

  String user();

  String key();

  String browserStackUrl();
}
