import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendingOptions {

    //sendNow variables:
    private static String nowRadioBtnId="il.co.mintapp.buyme:id/nowRadioButton";

    //selectByMail variables:
    private static String mailCheckboxClass = "il.co.mintapp.buyme:id/optionCheckBox";
    private static String mailFieldClass = "android.widget.EditText";
    private static String mailAdress = "cookie@gmail.com";

    //pressContinue variables:
    private static String continueId = "il.co.mintapp.buyme:id/goNextButton";

    //sendNow marks Send Now radio button
    public static void sendNow(){
        DriverInitiation.driver.findElement(By.id(nowRadioBtnId)).click();
    }

    //selectByMail selects 'by mail' option
    public static void selectByMail(){
        List<MobileElement> sendingOptions = DriverInitiation.driver.findElements(By.id(mailCheckboxClass));
        sendingOptions.get(2).click();

        DriverInitiation.driver.findElement(By.className(mailFieldClass)).sendKeys(mailAdress);

    }

    //pressContinue presses Continue button
    public static void pressContinue(){
        Keyboard.tryHideKeyboard();
        DriverInitiation.driver.findElement(By.id(continueId)).click();
    }
}
