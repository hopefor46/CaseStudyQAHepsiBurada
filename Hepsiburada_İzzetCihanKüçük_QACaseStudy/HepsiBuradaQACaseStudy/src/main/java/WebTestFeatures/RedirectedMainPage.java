package WebTestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedirectedMainPage {
    public WebDriver driver;
    By accountHolderName = new By.ByXPath("(//div[@id='myAccount']/span/a/span)[2]");

    public RedirectedMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement AcoountHolderName() {
        return driver.findElement(accountHolderName);
    }
}
