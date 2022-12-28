package objects;

import org.openqa.selenium.By;

public class pageGeneral {

    By input_Name = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]");
    By input_Desc = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]");
    By btn_create = By.xpath("//android.widget.Button[@content-desc='Create']");

    By btn_add = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button");

    By btn_submit = By.xpath("//android.widget.Button[@content-desc='Submit']");

    public By getInput_Name() {
        return input_Name;
    }

    public By getBtn_create() {
        return btn_create;
    }

    public By getInput_Desc() {
        return input_Desc;
    }

    public By getBtn_add() {
        return btn_add;
    }

    public By getBtn_submit() {
        return btn_submit;
    }
}
