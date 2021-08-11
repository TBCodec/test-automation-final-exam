package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DataTableWithDownloadPage {

    private WebDriver driver;

    By NAMES_IN_PAGE = By.xpath("//*[@id=\"example\"]//td[@class=\"sorting_1\"]");
    By NEXT_BUTTON = By.xpath("//a[@class=\"paginate_button next\"]");

    public DataTableWithDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> namesInPage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<String> names = new ArrayList<>();
        while (true){
            wait.until(ExpectedConditions.visibilityOfElementLocated(NAMES_IN_PAGE));
            List<WebElement> namesElements = driver.findElements(NAMES_IN_PAGE);
            for (WebElement element : namesElements){
                names.add(element.getText());
            }
            try {
                driver.findElement(NEXT_BUTTON).click();
            }
            catch (Exception e){
            break;
            }

        }

        return names;
    }


}
