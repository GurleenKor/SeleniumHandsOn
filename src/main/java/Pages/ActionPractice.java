package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ActionPractice extends BaseClass {

Actions builder =new Actions(driver);
    WebDriverWait wait= new WebDriverWait (driver, Duration.ofSeconds (20));
    @FindBy(xpath="/html/body/nav/div[1]/a/span")
    WebElement dropDown;

    @FindBy (xpath="//ul[@class=\"dropdown-menu dropdown_menu_multi_level hidden-xs hidden-sm\"]//li//a[contains(text(),\"Software Testing\")]")
        WebElement softwareTestingLink;

    @FindBy(className="open_search_overlay")
            WebElement searchBox;

    @FindBy(xpath = "/html/body/header/nav/div[3]")
    WebElement searchButton;

    public ActionPractice()
    {
//initialising the ActionPractice class
        PageFactory.initElements(driver,this);

    }

    public void moveToDropdown() {

          wait.until (ExpectedConditions.elementToBeClickable (dropDown));

            builder.moveToElement (dropDown).build ( ).perform ( );

    }

    public void clickLink() throws InterruptedException
    {
        Thread.sleep (6000);

        wait.until (ExpectedConditions.elementToBeClickable (softwareTestingLink));
        builder.moveToElement(softwareTestingLink).build ().perform ();
    }

    public  void moveToSearchBox() throws InterruptedException
    {
        Thread.sleep (4000);

        wait.until (ExpectedConditions.elementToBeClickable (searchBox));
        builder.moveToElement(searchBox).build().perform();
    }
    public void searchButton() throws InterruptedException

    {
        Thread.sleep (8000);
        builder.moveToElement(searchBox).build().perform();
        Action seriesOfAction ;


        seriesOfAction=  builder.sendKeys(searchBox, "Selenium").keyDown(searchButton, Keys.SHIFT).keyUp(searchButton,Keys.SHIFT).build();
        seriesOfAction.perform();
        Thread.sleep (5000);

    }





}
