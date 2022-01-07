package TestFiles;

import Pages.HomePage;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSetup {

    public WebDriver driver;
    HomePage page;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void verifyWithoutAddingCredential()throws Exception {
        page = new HomePage(driver);
        page.verifyTitlePage();
        page.clickLoginButton();

        TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
         File ss= takesScreenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("/Users/saby/Desktop/Screenshot\\ 2021-11-24\\ at\\ 3.39.56\\ AM.png");
        FileUtils.copyFile(ss,DestFile);


        page.closeAlert();
    }

    @Test(priority = 2)
    public void loginTest() {

        page = new HomePage(driver);
        page.verifyTitlePage();
        page.setUserTextbox("problem_user");
        page.setPassword("secret_sauce");
        page.clickLoginButton();


    }



    @AfterTest
    public void quitBrowser() throws Exception {


        driver.close();

        driver.quit();

    }


}
