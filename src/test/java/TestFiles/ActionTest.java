package TestFiles;

import Pages.ActionPractice;
import Pages.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ActionTest extends BaseClass {

 ActionPractice action;

    @Test
    public  void  testActions() throws InterruptedException {
        action= new ActionPractice ();

        action.moveToDropdown ( );

        action.clickLink ( );
        action.moveToSearchBox ( );
        action.searchButton ( );

    }

    @AfterTest

    public void quitBrowser()
    {
        driver.close ();
        driver.quit ();

    }





}
