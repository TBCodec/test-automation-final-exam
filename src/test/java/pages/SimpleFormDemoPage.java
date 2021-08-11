package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By ENTER_A_FIELD = By.id("sum1");
    By ENTER_B_FIELD = By.id("sum2");
    By GET_TOTAL_BUTTON = By.xpath("//*[@id=\"gettotal\"]/button");
    By GET_TOTAL_FIELD = By.id("displayvalue");

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeABField(String aNumber, String  bNumber){
        driver.findElement(ENTER_A_FIELD).sendKeys(aNumber);
        driver.findElement(ENTER_B_FIELD).sendKeys(bNumber);
    }

    public void clickGetTotalButton(){
        driver.findElement(GET_TOTAL_BUTTON).click();
    }

    public Integer getTotal(){
        String total = driver.findElement(GET_TOTAL_FIELD).getText();
        return Integer.parseInt(total);
    }


}