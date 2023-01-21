package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class drag {

    public void dragByElement(AppiumDriver driver, By startElement, By endElement) throws InterruptedException {
        TouchAction dragNDrop = new TouchAction(driver);
        WebElement start = driver.findElement(startElement);
        dragNDrop.longPress(element(start))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(element(driver.findElement(endElement)))
                .release().perform();
    }

}
