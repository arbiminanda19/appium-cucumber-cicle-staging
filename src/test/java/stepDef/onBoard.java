package stepDef;

import config.env;
import helper.scroll;
import objects.pageOnBoard;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class onBoard extends env {

    pageOnBoard pageOnBoard = new pageOnBoard();
    scroll scroll = new scroll();

    public void login(String type) throws InterruptedException {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_skip())
        );
        if (type.equals("Swipe")) {
            driver.findElement(pageOnBoard.getBtn_yes()).click();
            for (int i=0; i<=3; i++){
                scroll.swipeHorizontal(driver, 0.9, 0.3, 0.1, 0.3);
            }
        } else {
            driver.findElement(pageOnBoard.getBtn_skip()).click();
        }
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_toSignIn())
        );
        driver.findElement(pageOnBoard.getBtn_toSignIn()).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_signInGoogle())
        );
        driver.findElement(pageOnBoard.getBtn_signInGoogle()).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_account())
        );
        driver.findElement(pageOnBoard.getBtn_account()).click();
    }

}
