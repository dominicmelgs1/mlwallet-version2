package steps.kpx;

import org.openqa.selenium.NoSuchElementException;
import utilities.ReusableComponents.TOTPGenerator;

public class Login_Steps extends Base_Steps {

    public void signInGoogle(String role)throws NoSuchElementException {
        try{
            click(googlePageObjects.googleContainer(), "Google Sign in Container");
            switchToNextTab();
            typeEnter(googlePageObjects.emailField(), "Email Field", reader.getEmailByRole(role));
            typeEnter(googlePageObjects.passwordField(), "Password Field", reader.getPasswordByRole(role));
            click(googlePageObjects.anotherWayButton(), "Another way");
            click(googlePageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            typeEnter(googlePageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            switchToPreviousTab();
        }catch (Exception e){
            click(googlePageObjects.selectGoogleAuthenticator(), "Google Auth Option");
            typeEnter(googlePageObjects.codeField(), "Auth Key Field", TOTPGenerator.getTwoFactorCode());
            switchToPreviousTab();
        }
    }

    public void signInGoogleV2()throws Exception{
        // logging in google via clicking the email, this only happens when browser is not closed
        try{
            click(googlePageObjects.googleContainer(), "Google Sign in Container");
            switchToNextTab();
            click(googlePageObjects.chooseCurrentAccount(), getText(googlePageObjects.chooseCurrentAccount()));
            switchToPreviousTab();
        }catch (Exception e){
            click(googlePageObjects.googleContainer2(), "Google Sign in Container");
            switchToNextTab();
            click(googlePageObjects.chooseCurrentAccount(), getText(googlePageObjects.chooseCurrentAccount()));
            switchToPreviousTab();
        }
    }
    public void loginKpx(String role)throws Exception{
        waitSleep(5000);
        try{
            type(loginPageObjects.userNameField(),"kpx username field", reader.getKpxUsername(role));
            type(loginPageObjects.passwordField(), "kpx password field", reader.getKpxPassword(role));
            click(loginPageObjects.loginButton(), "Login button");

        }catch (Exception e){
            logFail("loginKpx, ","error "+ e);
        }
    }
    public void isInvalidAccount(){
        if(isVisible(loginPageObjects.invalidCredText(), getText(loginPageObjects.invalidCredText()))){
            logPass("isInvalidAccount ","Successfully Validated Invalid Account");
        }else{
            logFail("isInvalidAccount ","Failed to Validate");
        }

    }
}
