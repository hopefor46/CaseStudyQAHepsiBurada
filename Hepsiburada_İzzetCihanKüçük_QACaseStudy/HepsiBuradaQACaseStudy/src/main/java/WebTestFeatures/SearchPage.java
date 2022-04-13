package WebTestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    By searchArea = new By.ByXPath("//div[@id='SearchBoxOld']//input");
    By searchButton = new By.ByClassName("SearchBoxOld-buttonContainer");
    By searchResultSummaryText = new By.ById("SearchResultSummary");
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement SearchArea() {
        return driver.findElement(searchArea);
    }

    public WebElement SearchButton() {
        return driver.findElement(searchButton);
    }
    public WebElement SearchResultSummaryText() {
        return driver.findElement(searchResultSummaryText);
    }
}
