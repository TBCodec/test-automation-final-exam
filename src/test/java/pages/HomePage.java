package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    By POP_UP_CLOSE_BUTTON = By.xpath("//*[@id=\"at-cv-lightbox-close\"]");
    By INPUT_FORMS_BUTTON = By.xpath("//li[@class='tree-branch']//a[@href='#'][normalize-space()='Input Forms']");
    By SIMPLE_FORM_BUTTON = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Simple Form Demo']");
    By DROPDOWN_LIST_BUTTON = By.xpath("//li[@class='tree-branch']//a[text()='Select Dropdown List']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public SelectDropdownPage clickDropdownButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DROPDOWN_LIST_BUTTON));
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        return new SelectDropdownPage(driver);
    }
    public void clickInputFormsButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_FORMS_BUTTON));
        driver.findElement(INPUT_FORMS_BUTTON).click();

    }

    public SimpleFormDemoPage clickSimpleFormButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIMPLE_FORM_BUTTON));
        driver.findElement(SIMPLE_FORM_BUTTON).click();
        return new SimpleFormDemoPage(driver);
    }

    public void closePopUp(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(POP_UP_CLOSE_BUTTON));
        driver.findElement(POP_UP_CLOSE_BUTTON).click();
    }

}
