package WebTestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

    By firstItemShopCartHover = new By.ByXPath("(//div[@data-test-id='product-card-container'])[1]");
    By firstItemShopCartAdd = new By.ByXPath("//li[@id='i0']//button");
    By reactModalAdd = new By.ByXPath("//div[@class='ReactModalPortal']//button");
    By cartItemCount = new By.ById("cartItemCount");
    By shoppingCartButton = new By.ById("shoppingCart");
    By basketItemCount = new By.ById("basket-item-count");
    By iPhoneText = new By.ByXPath("(//section[@id='onboarding_item_list']//ul//li/div/div/div)[1]/div[2]/div[2]/a");
    public WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement FirstItemShopCartHover() {
        return driver.findElement(firstItemShopCartHover);
    }

    public WebElement FirstItemShopCartAdd() {
        return driver.findElement(firstItemShopCartAdd);
    }

    public WebElement ReactModalAdd() {
        return driver.findElement(reactModalAdd);
    }

    public WebElement CartItemCount() {
        return driver.findElement(cartItemCount);
    }

    public WebElement ShoppingCartButton() {
        return driver.findElement(shoppingCartButton);
    }

    public WebElement BasketItemCount() {
        return driver.findElement(basketItemCount);
    }

    public WebElement iPhoneText() {
        return driver.findElement(iPhoneText);
    }

    public By LocatorOfFirstItem() {
        return firstItemShopCartHover;
    }
}
