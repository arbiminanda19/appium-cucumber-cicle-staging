package objects;

import org.openqa.selenium.By;

public class pageGeneral {

    public By getInput_Name() {
        By input_Name = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]");
        return input_Name;
    }

    public By getBtn_create() {
        By btn_create = By.xpath("//android.widget.Button[@content-desc='Create']");
        return btn_create;
    }

    public By getInput_Desc() {
        By input_Desc = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]");
        return input_Desc;
    }

    public By getBtn_add() {
        By btn_add = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button");
        return btn_add;
    }

    public By getBtn_submit() {
        By btn_submit = By.xpath("//android.widget.Button[@content-desc='Submit']");
        return btn_submit;
    }
}
