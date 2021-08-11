package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectDropdownPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By SELECT_DAY_BUTTON = By.id("select-demo");
    By DAYS_OPTIONS = By.xpath("//*[@id=\"select-demo\"]/option");
    By DAY_SELECTED_FIELD = By.xpath("//*[@id=\"easycont\"]//p[@class=\"selected-value\"]");

    public SelectDropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSelectDayButton(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_DAY_BUTTON));
        driver.findElement(SELECT_DAY_BUTTON).click();
    }

    public void selectFromList(String day){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DAYS_OPTIONS));
        List<WebElement> optionElements = driver.findElements(DAYS_OPTIONS);
        for (WebElement element : optionElements){
            if (element.getText().equals(day)){
                element.click();
                break;
            }
        }
    }

    public String getSelectedDay(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DAY_SELECTED_FIELD));
        return driver.findElement(DAY_SELECTED_FIELD).getText();
    }

}
