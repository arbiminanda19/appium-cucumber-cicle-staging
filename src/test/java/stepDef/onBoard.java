package stepDef;

import config.env;
import objects.pageHome;
import objects.pageOnBoard;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class onBoard extends env {

    pageOnBoard pageOnBoard = new pageOnBoard();

    public void user_has_open_cicle_app() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_skip())
        );
    }

    public void user_click_skip_button() {
        driver.findElement(pageOnBoard.getBtn_skip()).click();
    }

    public void user_move_to_sign_in_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_toSignIn())
        );
        driver.findElement(pageOnBoard.getBtn_toSignIn()).click();
    }

    public void user_click_sign_in_by_google() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_signInGoogle())
        );
        driver.findElement(pageOnBoard.getBtn_signInGoogle()).click();
    }

    public void user_choose_account() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageOnBoard.getBtn_account())
        );
        driver.findElement(pageOnBoard.getBtn_account()).click();
    }

}
