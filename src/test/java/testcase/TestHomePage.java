package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class TestHomePage {

  private WebDriver webDriver = null;
  private HomePage homePage = null;

  @BeforeTest
  public void setup() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    webDriver.get("https://www.aspiration.com/");
  }

  @Test()
  public void test_two_card_products_available() {
    homePage = new HomePage(webDriver);
    Assert.assertEquals(homePage.getAspirationCardName(), "Aspiration");
    Assert.assertEquals(homePage.getAspirationPlusCardName(), "Aspiration Plus");
  }

  @Test()
  public void test_aspiration_card_form() {
    homePage = new HomePage(webDriver);
    Assert.assertEquals(homePage.getAspirationFormEmailTitle(), "Enter your email to get started");
  }

  @Test()
  public void test_aspiration_plus_card_form() {
    homePage = new HomePage(webDriver);
    Assert.assertEquals(homePage.getAspirationFormEmailTitle(), "Enter your email to get started");
  }

  @Test()
  public void test_aspiration_plus_card_plans() {
    homePage = new HomePage(webDriver);
    homePage.getPlansForAspirationCardPlus("test@yahoo.com");
    Assert.assertEquals(homePage.getAnnualPlanNameAspirationCardPlus(), "Annual Plan");
    Assert.assertEquals(homePage.getMonthlyPlanNameAspirationCardPlus(), "Pay Monthly Instead +");
  }

  @Test()
  public void test_aspiration_plus_card_yearly_plan() {
    homePage = new HomePage(webDriver);
    homePage.getPlansForAspirationCardPlus("test@yahoo.com");
    Assert.assertEquals(homePage.getRadioOptionYearlyPlan(), "$71.88 billed once a year.");
  }

  @Test()
  public void test_aspiration_plus_card_monthly_plan() {
    homePage = new HomePage(webDriver);
    Assert.assertEquals(homePage.getRadioOptionMonthlyPlan("test@yahoo.com"), "$7.99/mo.");
  }

  @AfterTest
  public void closeDriver() {
    webDriver.close();
  }
}
