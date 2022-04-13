package WebTests;

import WebTestFeatures.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginSearchAndShop extends DriverInitialization {

    public WebDriver driver;

    @BeforeTest
    public void Initialize() {
        driver = InitializeChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");

    }

    @Test(priority = 1)
    public void mainPageNavigation() {
        SoftAssert s = new SoftAssert();
        Actions a = new Actions(driver);
        MainPage mp = new MainPage(driver);
        boolean isOnMainPage = mp.GetTodaySpecial().isDisplayed();
        a.moveToElement(mp.LoginHover()).pause(1000).click(mp.Login()).build().perform();
        s.assertTrue(isOnMainPage);
    }

    @Test(priority = 2)
    public void Login() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        SoftAssert s = new SoftAssert();
        LoginPage lp = new LoginPage(driver);
        boolean isOnLoginPage = lp.LoginPageText().isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(lp.UsernameEntry()));
        lp.UsernameEntry().sendKeys("izzetcihank@gmail.com");
        lp.LoginButtonBeforePassword().click();
        wait.until(ExpectedConditions.visibilityOf(lp.PasswordEntry()));
        lp.PasswordEntry().sendKeys("WsxĞşö;12");
        wait.until(ExpectedConditions.elementToBeClickable(lp.LoginButtonAfterPassword()));
        lp.LoginButtonAfterPassword().click();
        s.assertTrue(isOnLoginPage);
    }

    @Test(priority = 3)
    public void Search() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        SoftAssert s = new SoftAssert();
        RedirectedMainPage rmp = new RedirectedMainPage(driver);
        SearchPage sp = new SearchPage(driver);
        String accountHolderNameActual = rmp.AcoountHolderName().getText();
        boolean successfulLogin = accountHolderNameActual.equalsIgnoreCase("İzzet Cihan Küçük");
        sp.SearchArea().sendKeys("iPhone11");
        sp.SearchButton().click();
        wait.until(ExpectedConditions.stalenessOf(sp.SearchResultSummaryText()));
        String summary = sp.SearchResultSummaryText().getText();
        boolean isIphone = summary.contains("iPhone11");
        s.assertTrue(isIphone);
        s.assertTrue(successfulLogin);
    }

    @Test(priority = 4)
    public void Shop() {
        SoftAssert s = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions a = new Actions(driver);
        ShopPage shop = new ShopPage(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(shop.LocatorOfFirstItem()));
        a.moveToElement(shop.FirstItemShopCartHover()).pause(1000).click(shop.FirstItemShopCartAdd()).build().perform();
        shop.ReactModalAdd().click();
        wait.until(ExpectedConditions.visibilityOf(shop.CartItemCount()));
        String countString = shop.CartItemCount().getText();
        int count = Integer.parseInt(countString);
        shop.ShoppingCartButton().click();
        String basketCountString = shop.BasketItemCount().getText();
        int countBasket = Integer.parseInt(basketCountString);
        String validationText = shop.iPhoneText().getText();
        boolean isIphone = validationText.contains("iPhone 11");
        s.assertTrue(isIphone);
        s.assertEquals(count, 1);
        s.assertEquals(countBasket, 1);


    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }


}
