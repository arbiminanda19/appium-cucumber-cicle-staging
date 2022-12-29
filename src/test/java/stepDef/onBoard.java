package stepDef;

import config.env;
import objects.pageOnBoard;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class onBoard extends env {

    pageOnBoard pageOnBoard = new pageOnBoard();

    public void login() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_skip())
        );
        driver.findElement(pageOnBoard.getBtn_skip()).click();
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
