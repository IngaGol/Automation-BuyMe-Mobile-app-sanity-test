import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInitiation {

    public static AndroidDriver<MobileElement> driver;

    //driverInit variables:
    private static String platformName = "Android";
    private static String deviceName = "Galaxy S8";

    //capabilities titles
    private static String capAppPackage = "appPackage";
    private static String capAppActivity = "appActivity";

    //tags from config.xml file
    private static String appPackageTag = "PACKAGE";
    private static String appActivityTag = "ACTIVITY";

    private static String appiumURL = "http://0.0.0.0:4723/wd/hub/";
    private static String xmlFileName = "config.xml";

    //driverInit initiates the capabilities and android driver
    public static void driverInit() throws IOException, SAXException, ParserConfigurationException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

        //getting app package and app activity from config.xml file
        String appPackage = InputOutput.getData(appPackageTag, xmlFileName);
        String appActivity = InputOutput.getData(appActivityTag, xmlFileName);

        capabilities.setCapability(capAppPackage, appPackage);
        capabilities.setCapability(capAppActivity, appActivity);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL(appiumURL), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
}
