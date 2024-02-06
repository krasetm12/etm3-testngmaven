package pages.autorization;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.base.BasePage;

import java.util.Set;

import static constants.Constant.Urls.ITEST_HOME_PAGE;
import static constants.Constant.LOGIN_MARKET;
import static constants.Constant.PASSWORD_MARKET;

public class Autorization extends BasePage {




  public Autorization(RemoteWebDriver driver){
      super(driver);
    }
    By understand_button =By.xpath("//button[@data-testid='understand-button']");
    By okay_button=By.xpath("//button[@data-testid='okay-button']");
    By authorization_button=By.xpath("//button[@data-testid='authorization-button']");
    By login=By.name("login");
    By password=By.name("password");
    By go_to_system=By.xpath("//button[@data-testid='go-to-system']");
    By composition_button=By.xpath("//button[@id='composition-button']");
    By drop_menu_item_exit=By.xpath("//li[@data-testid='drop-menu-item-exit']");

    public Autorization enterLoginPassword() throws Exception {
      open(ITEST_HOME_PAGE);
      System.out.println("начало теста");
      if (driver.findElements(understand_button).size() > 0) {
        waitForElementPresent(understand_button, "все понятно не появилось", 10);
        //System.out.println("все понятно" );
        driver.findElement(understand_button).click();
        this.takeSceenshot();
      } else if (driver.findElements(okay_button).size() > 0) {

        //System.out.println("все верно" );
        this.takeSceenshot();
        driver.findElement(okay_button).click();

      }

      waitForElementPresent(authorization_button, "кнопка войти не появилась", 10);
      driver.findElement(authorization_button).click();
      this.takeSceenshot();
      driver.findElement(login).clear();
      driver.findElement(login).sendKeys(LOGIN_MARKET);
      driver.findElement(password).clear();
      driver.findElement(password).sendKeys(PASSWORD_MARKET);
      driver.findElement(go_to_system).click();
      return this;
    }
  public Autorization deAuthorization() throws Exception {
    driver.findElement(composition_button).click();
  //String sessionId = driver.getSessionId().toString();
  Set<Cookie> cookiesListNewm = driver.manage().getCookies();
      for (Cookie getcookies : cookiesListNewm) {
    System.out.println(getcookies);
  }
  Cookie cookieSession = driver.manage().getCookieNamed("session-id");
      System.out.println(cookieSession.getValue());
      driver.findElement(drop_menu_item_exit).click();

      System.out.println("конец первого теста");
      return this;
    }

}
