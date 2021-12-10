package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ProductPage {

  @FindBy(xpath = "//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a")
  private WebElement spendAndSaveMenu;

  private WebDriver webDriver = null;

  public ProductPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  public void clickSpendAndSaveMenu() {
    spendAndSaveMenu.click();
  }

  public String getProductPageTitle() {
    return webDriver.getTitle();
  }
}
