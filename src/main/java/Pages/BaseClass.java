package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest

    public static void initDriver()
    {

        WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage ().window ().maximize ();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.edureka.co/");


    }




}
