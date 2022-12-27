package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Optional;
import pages.amazon.AmazonCommonPages;

import java.net.MalformedURLException;

public abstract class BaseTest {

  private WebDriver driver;

  public void setUp(@Optional("local-ff") String browser) throws MalformedURLException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions ops = new ChromeOptions();
    ops.addArguments("disable-infobars");
    driver = new ChromeDriver(ops);
    driver.manage().window().maximize();
  }

  public void tearDown() {
    driver.quit();
    driver = null;
  }

  protected WebDriver getDriver() {
    return driver;
  }


  protected AmazonCommonPages getAmazonCommonPage() {
    getDriver().get(Config.getInstance().getUrl());

    return new AmazonCommonPages(getDriver());
  }
}
