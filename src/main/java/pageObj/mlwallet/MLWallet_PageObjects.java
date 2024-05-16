package pageObj.mlwallet;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver.AppiumDriverManager;

import java.time.Duration;

public class MLWallet_PageObjects extends AppiumDriverManager{
    private final WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getAndroidDriver(), Duration.ofSeconds(20));
    public WebElement mobileNum_editText(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='967123']/child::android.view.ViewGroup/child::android.widget.EditText"))));
    }
    public WebElement login_btn(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//*[@resource-id='208465']"))));
    }
    public WebElement notifPermission_msg(){
        return driver.findElement(By.id("com.android.permissioncontroller:id/permission_message"));
    }
    public WebElement notifPermission_allowBtn(){
        return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
    }
    public WebElement otp_editText(int num){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("94NMBE-"+num+""));
    }
    public WebElement walletPin_btn(int num){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId(""+num+""));
    }
    public WebElement cashIn_icon(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Cash In"));
    }

    public WebElement sendMoney_icon(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Send"));
    }
    public WebElement withDraw_icon(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Withdraw"));
    }
    public WebElement cashInBranch_icon(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("ML Branch, \uE5CC"));
    }
    public WebElement amountEditText(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.ByClassName.className("android.widget.EditText"))));
    }
    public WebElement next_btn(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Next"));
    }
    public WebElement next_next(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]"));
    }
    public WebElement continue_btn(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Continue"));
    }
    public WebElement continue2_btn(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("CONTINUE"));
    }
    public WebElement allowLocation(){
        return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    }
    public WebElement cashIn_KPTN(){
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='0QMRD2']"));
    }

    public WebElement cashIn_TotalAmount(){
        return driver.findElement(AppiumBy.ById.id("08HQ6G"));
    }

    public WebElement usableBalance_Text(){
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='UTJ9TN']"));
    }
    public WebElement exit_Icon(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("\uE5CD"));
    }
    public WebElement sendMoney_branchOption(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Kwarta Padala, To any ML Branch, \uE5CC"));
    }
    public WebElement savedRecipient_kp(){
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='M7Q0IV']"));
    }
    public WebElement firstRecipient_kp(){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='HQCZ6L']"));
    }
    public WebElement selectRecipient_button(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Select Recipient"));
    }
    public WebElement noMiddleName_button(){
        return driver.findElement(By.xpath("//android.widget.ImageView"));
    }
    public WebElement selectPayment_Wallet(){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='391CJJ']"));
    }
    public WebElement confirm_Btn(){
        return driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Confirm"));
    }

    public WebElement kwartaPadala_KPTN(){
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id='56FWEC']"));
    }
    public WebElement BacktoHome(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"Back To Home\"]"));
    }

    public WebElement cashOut_icon(){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Withdraw\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView"));
    }
    public WebElement cashOut_MLBranch(){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"To any ML Branch, \uE5CC\"]/android.view.ViewGroup"));
    }
    public WebElement ContinueToCashOut(){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]"));
    }
    public WebElement CashOut_KPTN(){
        return driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"transaction-code\"]"));
    }
}
