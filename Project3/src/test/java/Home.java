
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class Home {
    //pickCategory variables:
    private static String categoryText ="new UiSelector().text(\"גיפט קארד למסעדות\")";

    //pickBusiness variables:
    private static String businessListId = "il.co.mintapp.buyme:id/businessName";

    //enterBudget variables:
    private static String budgetId = "il.co.mintapp.buyme:id/priceEditText";
    private static String budgetSum = "300";
    private static String selectId = "il.co.mintapp.buyme:id/purchaseButton";


    //pickCategory picks category of the gift from the screen.
    public static void pickCategory(){

        DriverInitiation.driver.findElementByAndroidUIAutomator(categoryText).click();
    }

    //pickBusiness picks one of the businesses from the selected category
    public static void pickBusiness(){

       List<MobileElement> businessList = DriverInitiation.driver.findElements(By.id(businessListId));
       businessList.get(3).click(); //בית תאילנדי

    }

    //enterBudget enters budget of the gift and presses Purchase
    public static void enterBudget(){
        DriverInitiation.driver.findElement(By.id(budgetId)).sendKeys(budgetSum);
        DriverInitiation.driver.findElement(By.id(selectId)).click();

    }

}
