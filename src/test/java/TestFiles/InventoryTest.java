package TestFiles;

import Pages.HomePage;
import Pages.Inventory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class InventoryTest {

    WebDriver driver;
    Inventory inventory;
    TestSetup test;
    HomePage page;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.saucedemo.com/");
        page= new HomePage(driver);
        page.setUserTextbox("standard_user");
        page.setPassword("secret_sauce");
        page.clickLoginButton();


//        loginTest();
    }

    @Test
    public void verifyFilter() throws  Exception {
        inventory = new Inventory(driver);
        inventory.selectOption("Name (Z to A)");
        TakesScreenshot ss = (TakesScreenshot)driver;
        File screenshot=ss.getScreenshotAs(OutputType.FILE);

        File dest = new File( "/Users/saby/Desktop/Screenshot\\ 2021-11-24\\ at\\ 3.39.56\\ AM.png");
        FileUtils.copyFile( screenshot,dest);

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
