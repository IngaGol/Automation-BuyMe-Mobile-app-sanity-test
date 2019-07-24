import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

public class SenderReceiverInfo {

    //enterInfo variables:
    private static String receiverId = "il.co.mintapp.buyme:id/toEditText";
    private static String blessingId = "il.co.mintapp.buyme:id/blessEditText";
    private static String senderId = "il.co.mintapp.buyme:id/userFrom";

    private static String receiverName = "Yael";
    private static String blessingText = "Congrats!";
    private static String senderName = "Yossi";

    //pressContinue variables:
    private static String continueId = "il.co.mintapp.buyme:id/goNextButton";
    private static String scrollId = "il.co.mintapp.buyme:id/fabAlikeContainer";

    //enterInfo fills sender and receiver details
    public static void enterInfo(){

        //pressing scroll button to see the end of the screen
        DriverInitiation.driver.findElement(By.id(scrollId)).click();

        DriverInitiation.driver.findElement(By.id(receiverId)).sendKeys(receiverName);
        Keyboard.tryHideKeyboard();
        DriverInitiation.driver.findElement(By.id(blessingId)).sendKeys(blessingText);
        Keyboard.tryHideKeyboard();
        DriverInitiation.driver.findElement(By.id(senderId)).clear();
        Keyboard.tryHideKeyboard();
        DriverInitiation.driver.findElement(By.id(senderId)).sendKeys(senderName);
        Keyboard.tryHideKeyboard();
    }

    //pressContinue presses Continue button
    public static void pressContinue(){

        DriverInitiation.driver.findElement(By.id(continueId)).click();
    }
}
