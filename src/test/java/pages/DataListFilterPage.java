package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DataListFilterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By CARD_NAMES_FIELDS = By.xpath("//div[@class=\"row\"]//h4");

    public DataListFilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getNameCards(){
        List<String> names = new ArrayList<>();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_NAMES_FIELDS));
        List<WebElement> namesElements = driver.findElements(CARD_NAMES_FIELDS);
        for (WebElement textInElement : namesElements){
            String name = textInElement.getText().replace("Name: ","");
            names.add(name);
        }
        return names;
    }




}
