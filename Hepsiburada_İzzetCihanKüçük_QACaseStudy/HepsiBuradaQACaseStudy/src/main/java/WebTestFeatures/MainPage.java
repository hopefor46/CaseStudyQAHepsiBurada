package WebTestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public WebDriver driver;
    By todaySpecial = new By.ByClassName("containerFullWidth");
    By loginHover = new By.ById("myAccount");
    By login = new By.ById("login");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement GetTodaySpecial() {
        return driver.findElement(todaySpecial);
    }

    public WebElement LoginHover() {
        return driver.findElement(loginHover);
    }

    public WebElement Login() {
        return driver.findElement(login);
    }
}
