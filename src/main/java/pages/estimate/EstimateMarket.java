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
  private final By top_menu_estimates
  try {
    WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-estimates']"));
    button.click();
  } catch (
  StaleElementReferenceException ex) {
    WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-estimates']"));
    button.click();
  }
      driver.findElement(By.xpath("//button[@id='composition-button']")).click();
      driver.findElement(By.xpath("//li[@data-testid='drop-menu-item-exit']")).click();
      System.out.println("конец второго теста" );
}
