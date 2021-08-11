package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataListFilterPage {

    private WebDriver driver;

    By CARD_NAMES_FIELDS = By.xpath("//div[@class=\"row\"]//h4");

    public DataListFilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getNameCards(){
        List<String> names = new ArrayList<>();
        List<WebElement> namesElements = driver.findElements(CARD_NAMES_FIELDS);
        for (WebElement textInElement : namesElements){
            String name = textInElement.getText().replace("Name: ","");
            names.add(name);
        }
        return names;
    }




}
