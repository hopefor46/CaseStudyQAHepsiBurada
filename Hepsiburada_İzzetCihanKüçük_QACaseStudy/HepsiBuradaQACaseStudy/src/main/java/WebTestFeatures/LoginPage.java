package WebTestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    By loginPageText = new By.ByXPath("//div[@class='_2y3R9t5DTaLmLvc6pMBJkS']");
    By usernameEntry = new By.ById("txtUserName");
    By passwordEntry = new By.ById("txtPassword");
    By loginButtonBeforePassword = new By.ById("btnLogin");
    By loginButtonAfterPassword = new By.ById("btnEmailSelect");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement LoginPageText(){
        return driver.findElement(loginPageText);
    }
    public WebElement UsernameEntry(){
        return driver.findElement(usernameEntry);
    }
    public WebElement LoginButtonBeforePassword(){
        return driver.findElement(loginButtonBeforePassword);
    }
    public WebElement PasswordEntry(){
        return driver.findElement(passwordEntry);
    }
    public WebElement LoginButtonAfterPassword(){
        return driver.findElement(loginButtonAfterPassword);
    }
}
