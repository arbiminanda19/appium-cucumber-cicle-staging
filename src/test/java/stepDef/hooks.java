package stepDef;

import config.env;
import helper.loginMethod;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class hooks extends env {

    onBoard onBoard = new onBoard();
    loginMethod loginMethod = new loginMethod();

    @Before
    public void before() throws IOException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_3a_API_32_arm64-v8a");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "staging.cicle");
        capabilities.setCapability("appActivity", "staging.cicle.MainActivity");
        //capabilities.setCapability("app", "src/test/resources/app/cicle-staging.apk");

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, duration);
        String chosenLoginMethod = loginMethod.getLoginMethod();
        onBoard.login(chosenLoginMethod);
    }

    @After
    public void after(){
        driver.quit();
    }

}
