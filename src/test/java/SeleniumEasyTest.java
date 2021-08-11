import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumEasyTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void Setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        homePage = new HomePage(driver);
        homePage.closePopUp();
    }


    @Test
    public void TestTwoInputs()
    {
        String numberA = "5";
        String numberB = "4";
        homePage.clickInputFormsButton();
        SimpleFormDemoPage simpleFormDemoPage = homePage.clickSimpleFormButton();
        simpleFormDemoPage.typeABField(numberA, numberB);
        simpleFormDemoPage.clickGetTotalButton();
        Integer result = simpleFormDemoPage.getTotal();
        Integer expected = 9;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestDaySelectionList()
    {
        String selectDay = "Monday";
        homePage.clickInputFormsButton();
        SelectDropdownPage selectDropdownPage = homePage.clickDropdownButton();
        selectDropdownPage.clickSelectDayButton();
        selectDropdownPage.selectFromList(selectDay);
        String expected = "Day selected :- " + selectDay;
        String result = selectDropdownPage.getSelectedDay();
        Assertions.assertEquals(expected, result);
    }



    @Test
    public void TestAlertPopUp()
    {
        homePage.clickAlertsAndModals();
        BootstrapModalPage bootstrapModalPage = homePage.clickBootstrapModal();
        bootstrapModalPage.clickLauncModalButton();
        String result = bootstrapModalPage.getTextFromModalTitle();
        String expected = "This is the place where the content for the modal dialog displays";
        Assertions.assertTrue(result.contains(expected));
        bootstrapModalPage.clickCloseModalTitle();
    }

    @Test
    public void TestNameCards()
    {
        homePage.clickListBoxButton();
        DataListFilterPage dataListFilterPage = homePage.clickDataListFilter();
        List<String> result = dataListFilterPage.getNameCards();
        List<String> expected = new ArrayList<>();
        expected.add("Tyreese Burn");
        expected.add("Brenda Tree");
        expected.add("Glenn Pho shizzle");
        expected.add("Brian Hoyies");
        expected.add("Glenn Pho shizzle");
        expected.add("Arman Cheyia");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestTableContent()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/table-data-download-demo.html page
         * Write test to get names of table.
         * Get every name found in the first column of table. Collect names in every page of and store all of them in the names.txt file.
         * Use the given variables to achieve successfully running test.
         * */

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Assertions.assertEquals(31, lines);
    }

    @AfterEach
    public void Close()
    {
        driver.quit();
    }


}
