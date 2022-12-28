package objects;

import org.openqa.selenium.By;

public class pageHome {

    By img_logo = By.xpath("//android.widget.ImageView[@content-desc='logo']");
    By btn_createCompany = By.xpath("//android.widget.Button[@content-desc='Create New Company']");

    By input_companyName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]");
    By input_companyDesc = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]");
    By btn_create = By.xpath("//android.widget.Button[@content-desc='Create']");

    By txt_successCreateCompany = By.xpath("//android.view.View[@content-desc='Successfully create company user']");

    public By getImg_logo() {
        return img_logo;
    }

    public By getBtn_createCompany() {
        return btn_createCompany;
    }

    public By getInput_companyName() {
        return input_companyName;
    }

    public By getBtn_create() {
        return btn_create;
    }

    public By getInput_companyDesc() {
        return input_companyDesc;
    }

    public By getTxt_successCreateCompany() {
        return txt_successCreateCompany;
    }
}
