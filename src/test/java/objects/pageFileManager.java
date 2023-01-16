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

}
