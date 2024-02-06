package pages.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static constants.Constant.TimeOutVariables.EXPLICIT_WAIT;

public class BasePage {
  protected RemoteWebDriver driver;
  public BasePage(RemoteWebDriver driver){

    this.driver=driver;
  }
  public void open(String url){

    driver.get(url);
  }


  public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT) );
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.presenceOfElementLocated(by)
    );
  }
  public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.click();

    return element;

  }
  public WebElement waitForElementAndClickable(By by, String error_message, long timeoutInSeconds){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT) );
    wait.withMessage(error_message + "\n");
    return wait.until
            (ExpectedConditions.elementToBeClickable(by));

  }


  public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.sendKeys(value);

    return element;

  }

  public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT) );
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.invisibilityOfElementLocated(by)
    );
  }

  public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    element.clear();
    return element;
  }
  public WebElement waitForElementLocated(By by, String error_message, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT) );
    wait.withMessage(error_message + "\n");

    return wait.until(
            ExpectedConditions.visibilityOfElementLocated(by)
    );
  }
  public void clickVisible(By by ,String error_message, long timeoutInSeconds ){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT) );
    wait.until(ExpectedConditions.elementToBeClickable(by));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    final Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(by)).click().perform();
  }

  public void takeSceenshot() throws Exception {
    TakesScreenshot ts = (TakesScreenshot)this.driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source, new File("./screenshot.png"));
    System.out.println("The Screenshot is taken...");

  }
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
