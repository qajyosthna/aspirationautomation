package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProductPage;

import java.time.Duration;

public class TestProductPage {

  private WebDriver webDriver = null;
  private ProductPage productPage = null;

  @BeforeTest
  public void setup() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    webDriver.get("https://www.aspiration.com/");
  }

  @Test()
  public void test_product_page_success() {
    productPage = new ProductPage(webDriver);
    productPage.clickSpendAndSaveMenu();
    Assert.assertEquals(productPage.getProductPageTitle(), "Aspiration Spend & Save");
  }


  @AfterTest
  public void closeDriver() {
    webDriver.quit();
  }
}
