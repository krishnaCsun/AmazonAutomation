package amazon;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.amazon.AmazonCommonPages;
import tools.BaseTest;

import java.net.MalformedURLException;

public class SamsungTvPageContentTest extends BaseTest {
    private AmazonCommonPages amazonLandingPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        super.setUp("local-chrome");
        amazonLandingPage = getAmazonCommonPage();
    }

    @Test
    @Description("Verify About this Item section is present in Amazon Samsung TV Product")
    public void verifySamsungTVProduct() {


        amazonLandingPage.clickHamburger();
        amazonLandingPage.selectTvAppEle();
        amazonLandingPage.selectTelevision();
        amazonLandingPage.filterSamsungTv();
        amazonLandingPage.sortHightoLowPrice();
        amazonLandingPage.selectProductN2();

        String content = amazonLandingPage.aboutItemText();
        System.out.print(content);

        Assert.assertFalse(amazonLandingPage.aboutItemText().isEmpty(), "Content is Verified and Printed");
    }


    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
