
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BuyMe {

    //setUp variables:
    private static String reportMainScreen = "BuyMe Main Screen";

    //test01_Intro_Reg variables:
    private static String reportSignIn = "Sign in was performed.";
    private static String reportGoogleSignIn = "Sign in using Google account option was selected.";
    private static String reportSelectUser = "Google user was selected.";

    //test02_Home variables:
    private static String reportSelectCategory = "Gift Category was selected.";
    private static String reportSelectBusiness = "Business to get the gift from, was selected.";
    private static String reportEnterBudget = "Budget was entered.";

    //test03_Sender_Receiver variables:
    private static String reportInfoFilled = "Sender and Receiver information was filled.";
    private static String reportContinue = "Continue button was pressed.";

    //test04_Sending variables:
    private static String reportNowMail = "Send Now radio button was selected. Mail was filled.";
    private static String buttonToWaitFor = "il.co.mintapp.buyme:id/goNextButton";
    private static String reportPayment = "All details were filled, payment screen appeared.";



    @BeforeClass
    public static void setUp() {

        //Initializing the driver
        try {
            DriverInitiation.driverInit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //Initializing report
        Report.reportInitiation();

        Report.createLogLine(reportMainScreen);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01_Intro_Reg() {
        IntroAndReg.pressSignIn();
        Report.createLogLine(reportSignIn);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IntroAndReg.pressGoogleLogin();
        Report.createLogLine(reportGoogleSignIn);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IntroAndReg.selectUser();
        Report.createLogLine(reportSelectUser);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02_Home(){
        Home.pickCategory();
        Report.createLogLine(reportSelectCategory);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Home.pickBusiness();
        Report.createLogLine(reportSelectBusiness);
        Home.enterBudget();
        Report.createLogLine(reportEnterBudget);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03_Sender_Receiver(){
        SenderReceiverInfo.enterInfo();
        Report.createLogLine(reportInfoFilled);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SenderReceiverInfo.pressContinue();
        Report.createLogLine(reportContinue);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04_Sending(){
        SendingOptions.sendNow();
        SendingOptions.selectByMail();

        Report.createLogLine(reportNowMail);
        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SendingOptions.pressContinue();
        WebDriverWait wait = new WebDriverWait(DriverInitiation.driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(DriverInitiation.driver.findElement(By.id(buttonToWaitFor))));
        Report.createLogLine(reportPayment);
    }

    @AfterClass
    public static void afterAll(){

        try {
            Report.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creating Report
        Report.createFinalReport();
        DriverInitiation.driver.quit();
    }
}