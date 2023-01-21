package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class click {

    public void clickByCoordinat(AppiumDriver driver, double xd, double yd) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * xd);
        int y = (int) (size.height * yd);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(x, y)).perform();
    }

}
