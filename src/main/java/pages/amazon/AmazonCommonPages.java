package pages.amazon;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonCommonPages extends BasePage {

    private static final By hamburgerMenu = By.id("nav-hamburger-menu");
    private static final By tvApplianceElectronicSection = By.xpath("//div[text()=\"TV, Appliances, Electronics\"]");
    private static final By televisionSubSection = By.xpath("//a[text()=\"Televisions\"]");
    private static final By samsungFilter = By.xpath("//*[text()=\"Samsung\"]//..//*[@type=\"checkbox\"]//..");
    private static final By sortByDropDown = By.id("s-result-sort-select");
    private static final By priceHighToLowLink = By.id("s-result-sort-select_2");
    private static final By product2 = By.xpath("//div[@data-index=2]");
    private static final By aboutItemText = By.xpath("//*[text()=\" About this item \"]//..//ul");

    public AmazonCommonPages(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean clickHamburger() {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(hamburgerMenu).click();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public boolean selectTvAppEle() {
        try {
            driver.findElement(tvApplianceElectronicSection).click();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public boolean selectTelevision() {
        try {
            driver.findElement(televisionSubSection).click();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public boolean filterSamsungTv() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int y = driver.findElement(samsungFilter).getLocation().y;
            y = y - 30;
            int x = 0;
            js.executeScript("window.scrollBy(" + x + ", " + y + ");");
            driver.findElement(samsungFilter).click();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public boolean sortHightoLowPrice() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(sortByDropDown));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(priceHighToLowLink));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public boolean selectProductN2() {
        try {
            driver.findElement(product2).click();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step
    public String aboutItemText() {
        try {
            Set windows = driver.getWindowHandles();
            Iterator winItr = windows.iterator();
            winItr.next();
            driver.switchTo().window(winItr.next().toString());
            String content = driver.findElement(aboutItemText).getText();
            return content;
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
