package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Inventory {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    WebElement filterDropDown;

    @FindBy(id = "id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"")
    WebElement addToCartButton;



    public Inventory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOption(String string) {
        try {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
            wait.until(ExpectedConditions.elementToBeClickable(filterDropDown));

           // filterDropDown.sendKeys(string);

          Select select = new Select(filterDropDown);

           select.selectByVisibleText(string);
         //   filterDropDown.sendKeys(string);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void addToCart() {
        addToCartButton.click();

    }


}
