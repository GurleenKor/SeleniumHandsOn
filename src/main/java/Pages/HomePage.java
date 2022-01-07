package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(id="user-name")
    WebElement userTextbox;

    @FindBy(id="password")
    WebElement passTextBox;

    @FindBy(id="login-button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button")
    WebElement popClose;


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setUserTextbox(String username) {
        userTextbox.sendKeys(username);
    }
    public void setPassword(String pass)
    {
        passTextBox.sendKeys(pass);

    }

    public void clickLoginButton()
    {
        loginButton.click();

    }

    public void verifyTitlePage()
    {
        String title="Swag Labs";
        Assert.assertEquals(title,driver.getTitle());
    }

    public void closeAlert()
    {
       new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(popClose));
        popClose.click();
    }




}
