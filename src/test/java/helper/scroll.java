package helper;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class scroll {

    By scrollDown = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");

    public By getScrollDown() {
        return scrollDown;
    }
}
