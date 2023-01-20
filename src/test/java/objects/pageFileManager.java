package objects;

import helper.accessFile;
import org.openqa.selenium.By;

public class pageFileManager {

    public By getBtn_image() {
        By btn_image = By.xpath("//*/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.CompoundButton[1]");
        return btn_image;
    }

    public By getBtn_cardImage() {
        By btn_cardImage = By.xpath("//*/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/androidx.cardview.widget.CardView[1]");
        return btn_cardImage;
    }

    By btn_sideBar = By.xpath("//*[@class = 'android.widget.ImageButton' and (@text = '' or . = '')]");

    By btn_drive = By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'arbiminanda49@gmail.com' or . = 'arbiminanda49@gmail.com') and @resource-id = 'android:id/summary']/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout");

    By btn_myDrive = By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'My Drive' or . = 'My Drive') and @resource-id = 'android:id/title']/parent::android.widget.LinearLayout/parent::androidx.cardview.widget.CardView/parent::androidx.cardview.widget.CardView");

    By btn_cardImageDrive = By.xpath("//*[@class = 'androidx.cardview.widget.CardView' and @resource-id = 'com.google.android.documentsui:id/item_root' and (@text = '' or . = '')]");

    public By getBtn_sideBar() {
        return btn_sideBar;
    }

    public By getBtn_drive() {
        return btn_drive;
    }

    public By getBtn_myDrive() {
        return btn_myDrive;
    }

    public By getBtn_cardImageDrive() {
        return btn_cardImageDrive;
    }
}
