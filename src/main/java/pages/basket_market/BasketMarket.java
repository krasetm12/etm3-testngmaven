package pages.basket_market;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.base.BasePage;

public class BasketMarket extends BasePage {
  public BasketMarket(RemoteWebDriver driver){
    super(driver);
  }
  By understand_button =By.xpath("//button[@data-testid='understand-button']");
  By okay_button=By.xpath("//button[@data-testid='okay-button']");
  By authorization_button=By.xpath("//button[@data-testid='authorization-button']");
  By login=By.name("login");
  By password=By.name("password");
  By go_to_system=By.xpath("//button[@data-testid='go-to-system']");
  By composition_button=By.xpath("//button[@id='composition-button']");
  public BasketMarket testMakingAnOrderByPickUpByWriteScore(){
    return this;
  }
}
