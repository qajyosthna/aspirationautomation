package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomePage {

  @FindBy(xpath = "//*[@id=\"price-card-2\"]")
  private WebElement cardAspiration;

  @FindBy(xpath = "//*[@id=\"price-card-2\"]/div[1]/h3[2]")
  private WebElement cardAspirationName;

  @FindBy(xpath = "//*[@id=\"price-card-3\"]")
  private WebElement cardAspirationPlus;

  @FindBy(xpath = "//*[@id=\"price-card-3\"]/div[1]/h3[1]")
  private WebElement cardAspirationPlusName;

  @FindBy(xpath = "//h5[@class='Text-sc-1yqq6iv-0 croXTM atom-text']")
  private WebElement aspirationCardFormEmailTitle;

  @FindBy(xpath = "//input[@class='Element-sc-1dc3ws0-0 Input-sc-siz8by-0 hclUa-d hdbtiA atom-input ']")
  private WebElement emailAddressAspirationCardPlus;

  @FindBy(xpath = "//button[@data-testid=\"signup-cta-modal\"]")
  private WebElement getStartedButtonAspirationCardPlus;

  @FindBy(xpath = "//h5[@class='Text-sc-1yqq6iv-0 kveyXV atom-text']")
  private WebElement annualPlanNameAspirationCardPlus;

  @FindBy(xpath = "//label[@class='Text-sc-1yqq6iv-0 dxZKub atom-text']")
  private WebElement monthlyPlanNameAspirationCardPlusLabel;

  @FindBy(xpath = "//p[@class='Text-sc-1yqq6iv-0 jCNckS atom-text']")
  private WebElement radioOptionYearlyPlan;

  @FindBy(xpath = "//p[@class='Text-sc-1yqq6iv-0 bPTGa atom-text']")
  private WebElement radioOptionMonthlyPlan;

  private WebDriver webDriver = null;

  public HomePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  public String getAspirationCardName() {
    JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    jse.executeScript("window.scrollBy(0,7000)");
    return cardAspirationName.getAttribute("innerHTML");
  }

  public String getAspirationPlusCardName() {
    JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    jse.executeScript("window.scrollBy(0,7000)");
    return cardAspirationPlusName.getAttribute("innerHTML");
  }

  public void clickAspirationCard() {
    JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    jse.executeScript("window.scrollBy(0,7000)");
    cardAspiration.click();
  }

  public String getAspirationFormEmailTitle() {
    clickAspirationCard();
    Set<String> windows = webDriver.getWindowHandles();
    webDriver.switchTo().window(windows.iterator().next());
    return aspirationCardFormEmailTitle.getAttribute("innerHTML");
  }

  public void clickAspirationPlusCard() {
    JavascriptExecutor jse = (JavascriptExecutor) webDriver;
    jse.executeScript("window.scrollBy(0,7000)");
    cardAspirationPlus.click();
  }

  public void enterEmailAddressOnAspirationCardPlus(String email) {
    Set<String> windows = webDriver.getWindowHandles();
    webDriver.switchTo().window(windows.iterator().next());
    emailAddressAspirationCardPlus.sendKeys(email);
  }

  public void clickGetStartedButtonOnAspirationCardPlus() {
    getStartedButtonAspirationCardPlus.click();
  }

  public String getAnnualPlanNameAspirationCardPlus() {
    return annualPlanNameAspirationCardPlus.getText();
  }

  public String getMonthlyPlanNameAspirationCardPlus() {
    return monthlyPlanNameAspirationCardPlusLabel.getText();
  }

  public void getPlansForAspirationCardPlus(String email) {
    clickAspirationPlusCard();
//    try {
//      Thread.sleep(1500);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

    enterEmailAddressOnAspirationCardPlus(email);
    clickGetStartedButtonOnAspirationCardPlus();
  }

  public void clickRadioOptionMonthlyPlan() {
    monthlyPlanNameAspirationCardPlusLabel.click();
  }

  public String getRadioOptionMonthlyPlan(String email) {
    getPlansForAspirationCardPlus(email);
    clickRadioOptionMonthlyPlan();
    return radioOptionMonthlyPlan.getText();
  }

  public String getRadioOptionYearlyPlan() {
    return radioOptionYearlyPlan.getText();
  }
}
