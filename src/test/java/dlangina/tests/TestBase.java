package dlangina.tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static dlangina.helpers.Attach.getSessionId;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dlangina.drivers.BrowserstackMobileDriver;
import dlangina.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

  @BeforeAll
  public static void setup() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    Configuration.browser = BrowserstackMobileDriver.class.getName();
    Configuration.browserSize = null;
    Configuration.timeout = 10000;
    Configuration.startMaximized = false;
  }

  @BeforeEach
  public void startDriver() {
    open();
  }

  @AfterEach
  public void afterEach() {
    String sessionId = getSessionId();
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    closeWebDriver();
    Attach.attachVideo(sessionId);
  }
}

