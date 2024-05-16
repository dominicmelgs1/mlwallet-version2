package pageObj.mlkpx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.Driver.DriverManager.getDriver;

public class Login_PageObjects{

    public WebElement userNameField(){
        return getDriver().findElement(By.name("username"));
    }
    public WebElement passwordField(){
        return getDriver().findElement(By.name("password"));
    }

    public WebElement invalidCredText(){
        return getDriver().findElement(By.cssSelector("[class='sc-aXZVg FiXoI']"));
    }
    public WebElement loginButton(){
        return getDriver().findElement(By.cssSelector("[type='submit']"));
    }

}
