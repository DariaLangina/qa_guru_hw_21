package dlangina.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserStackConfig extends Config {

  String url();

  String user();

  String key();
}
