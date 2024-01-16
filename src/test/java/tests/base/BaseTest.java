package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.autorization.Autorization;
import pages.base.BasePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.Urls.SELENIUM_URL;

public class BaseTest  {
  protected RemoteWebDriver driver;

  {
    try {
      driver = CommonActions.createDriver();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  protected BasePage basepage = new BasePage(driver);
  protected Autorization autorization = new Autorization(driver);



  @AfterTest
  public void clearCookiesAndLocalStorage(){
    if (CLEAR_COOKIES_AND_STORAGE){
      JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
      driver.manage().deleteAllCookies();
      javascriptExecutor.executeScript("window.sessionStorage.clear()");
    }
  }
//  @BeforeTest
//  public void start() throws Exception {
//    driver = new RemoteWebDriver(
//            new URL(SELENIUM_URL),
//            new ChromeOptions()
//    );
//    this.driver.manage().window().maximize();
//    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  }
  @AfterSuite (alwaysRun = true)
  public void closeSeleniumSession() {
    if(HOLD_BROWSER_OPEN){
        //driver.close();
        driver.quit();
        }

  }
}
