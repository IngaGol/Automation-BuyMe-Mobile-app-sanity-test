import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class IntroAndReg {

    //pressSignIn variables:
    private static String signInId = "il.co.mintapp.buyme:id/skipButton";

    //pressGoogleLogin variables:
    private static String signInGoogleId = "il.co.mintapp.buyme:id/googleButton";

    //selectUser variables:
    private static String usersListClass = "android.widget.LinearLayout";


    public static void pressSignIn(){
        DriverInitiation.driver.findElement(By.id(signInId)).click();
    }

    public static void pressGoogleLogin(){

        DriverInitiation.driver.findElement(By.id(signInGoogleId)).click();
    }

    public static void selectUser(){
        List<MobileElement> users = DriverInitiation.driver.findElements(By.className(usersListClass));
        System.out.println(users.get(0).getText());
        users.get(0).click();

    }

}
