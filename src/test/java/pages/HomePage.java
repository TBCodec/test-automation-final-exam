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
    By ALERTS_AND_MODALS = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Alerts & Modals']");
    By BOOTSTRAP_MODALS = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Bootstrap Modals']");
    By LIST_BOX_BUTTON = By.xpath("//li[@class='tree-branch']//a[normalize-space()='List Box']");
    By DATA_LIST_FILTER = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Data List Filter']");
    By TABLE_BUTTON = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Table']");
    By TABLE_DATA_DOWNLOAD = By.xpath("//li[@class='tree-branch']//a[normalize-space()='Table Data Download']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public DataTableWithDownloadPage clickDataTable(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_DATA_DOWNLOAD));
        driver.findElement(TABLE_DATA_DOWNLOAD).click();
        return new DataTableWithDownloadPage(driver);
    }

    public DataListFilterPage clickDataListFilter(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DATA_LIST_FILTER));
        driver.findElement(DATA_LIST_FILTER).click();
        return new DataListFilterPage(driver);
    }

    public BootstrapModalPage clickBootstrapModal(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BOOTSTRAP_MODALS));
        driver.findElement(BOOTSTRAP_MODALS).click();
        return new BootstrapModalPage(driver);
    }

    public SelectDropdownPage clickDropdownButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DROPDOWN_LIST_BUTTON));
        driver.findElement(DROPDOWN_LIST_BUTTON).click();
        return new SelectDropdownPage(driver);
    }

    public SimpleFormDemoPage clickSimpleFormButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIMPLE_FORM_BUTTON));
        driver.findElement(SIMPLE_FORM_BUTTON).click();
        return new SimpleFormDemoPage(driver);
    }

    public void clickTableButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_BUTTON));
        driver.findElement(TABLE_BUTTON).click();
    }

    public void clickListBoxButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LIST_BOX_BUTTON));
        driver.findElement(LIST_BOX_BUTTON).click();
    }

    public void clickAlertsAndModals(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERTS_AND_MODALS));
        driver.findElement(ALERTS_AND_MODALS).click();

    }

    public void clickInputFormsButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_FORMS_BUTTON));
        driver.findElement(INPUT_FORMS_BUTTON).click();

    }

    public void closePopUp(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(POP_UP_CLOSE_BUTTON));
        driver.findElement(POP_UP_CLOSE_BUTTON).click();
    }



}
