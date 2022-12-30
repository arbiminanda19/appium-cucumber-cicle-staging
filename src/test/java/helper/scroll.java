package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class scroll {

    public void swipeHorizontal(AppiumDriver driver, double start_xd, double start_yd, double end_xd, double end_yd) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int start_x = (int) (size.width * start_xd);
        int start_y = (int) (size.height * start_yd);
        int end_x = (int) (size.width * end_xd);
        int end_y = (int) (size.height * end_yd);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

}
