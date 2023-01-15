package objects;

import org.openqa.selenium.By;

public class pageOnBoard {

    public By getBtn_skip() {
        By btn_skip = By.xpath("//android.view.View[@content-desc='Skip']");
        return btn_skip;
    }

    public By getBtn_toSignIn() {
        By btn_toSignIn = By.xpath("//android.widget.Button[@content-desc='Go to Sign In']");
        return btn_toSignIn;
    }

    public By getBtn_signInGoogle() {
        By btn_signInGoogle = By.xpath("//android.widget.ImageView[@content-desc='Sign in with Google Account']");
        return btn_signInGoogle;
    }

    public By getBtn_account() {
        By btn_account = By.xpath("//android.widget.TextView[@resource-id='com.google.android.gms:id/account_display_name']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout");
        return btn_account;
    }

    public By getBtn_yes() {
        By btn_yes = By.xpath("//android.widget.Button[@content-desc='Yes!']");
        return btn_yes;
    }

}
