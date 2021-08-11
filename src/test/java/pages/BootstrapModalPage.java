package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapModalPage {

    private WebDriver driver;

    By LAUNCH_MODAL_BUTTON = By.xpath("//a[@href=\"#myModal0\"]");
    By MODAL_TITLE_TEXT_FIELD = By.xpath("//*[@id=\"myModal0\"]//div[@class=\"modal-body\"]");
    By CLOSE_MODAL_TITLE = By.xpath("//div[@id='myModal0']//a[@class='btn']");

    public BootstrapModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLauncModalButton(){
        driver.findElement(LAUNCH_MODAL_BUTTON).click();
    }

    public String getTextFromModalTitle(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_TITLE_TEXT_FIELD));
        return driver.findElement(MODAL_TITLE_TEXT_FIELD).getText();
    }

    public void clickCloseModalTitle(){
        driver.findElement(CLOSE_MODAL_TITLE).click();
    }

}
