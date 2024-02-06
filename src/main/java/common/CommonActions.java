package common;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static common.Config.BROWSER_AND_PLATFORM;
import static constants.Constant.TimeOutVariables.IMPLICIT_WAIT;
import static constants.Constant.Urls.SELENIUM_URL;

public class CommonActions  {
  public static RemoteWebDriver createDriver() throws MalformedURLException {

    RemoteWebDriver driver = null;
    switch (BROWSER_AND_PLATFORM){
      case "CHROME":


        driver = new RemoteWebDriver( new URL(SELENIUM_URL),
                new ChromeOptions()
        );

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setHeadless(false);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '1'");
        break;

      case "CHROME_w/t_js":

        ChromeOptions optionsJS = new ChromeOptions();
        optionsJS.setHeadless(false);
        optionsJS.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        optionsJS.setExperimentalOption("prefs", prefs);
        driver = new  RemoteWebDriver(optionsJS);
        JavascriptExecutor executorJS = (JavascriptExecutor)driver;
        executorJS.executeScript("document.body.style.zoom = '1'");
        break;

      case "FIREFOX":

        FirefoxOptions op= new FirefoxOptions();
        op.setHeadless(false);
//                DesiredCapabilities dc = new DesiredCapabilities();
//                dc.setJavascriptEnabled(false);
//                op.merge(dc);
        driver = new RemoteWebDriver(op);
        break;
      default:
        Assert.fail("INCORRECT BROWSER NAME: " + BROWSER_AND_PLATFORM);
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    return driver;
  }
}
