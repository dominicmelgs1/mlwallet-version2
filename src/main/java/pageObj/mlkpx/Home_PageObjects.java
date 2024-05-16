package pageObj.mlkpx;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static utilities.Driver.DriverManager.getDriver;

public class Home_PageObjects{
    public WebElement searchField (){
        return getDriver().findElement(By.cssSelector("[placeholder=\"Search MLKP\"]"));
    }
}
