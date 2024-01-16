package pages.estimate;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.base.BasePage;

public class EstimateMarket extends BasePage {
  public EstimateMarket(RemoteWebDriver driver){

    super(driver);
  }
  private final By top_menu_estimates=By.xpath("//a[@data-testid='top-menu-estimates']");
  By go_to_system=By.xpath("//button[@data-testid='go-to-system']");
  By composition_button=By.xpath("//button[@id='composition-button']");
  By drop_menu_item_exit=By.xpath("//li[@data-testid='drop-menu-item-exit']");

  public EstimateMarket AddEstimateToBasket(){
    try {
      WebElement button = driver.findElement(top_menu_estimates);
      button.click();
    } catch (
            StaleElementReferenceException ex) {
      WebElement button = driver.findElement(top_menu_estimates);
      button.click();
    }
    driver.findElement(composition_button).click();
    driver.findElement(drop_menu_item_exit).click();
    System.out.println("конец второго теста" );
    return this;
  }

}
