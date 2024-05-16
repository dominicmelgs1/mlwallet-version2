package testCases.kpx;

import base.BaseTest;

import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;



public class LoginT extends BaseTest {

    @Test(priority = 1)
    public void loginValid()throws Exception{
       this.loginSteps.signInGoogle("teller");
       this.loginSteps.loginKpx("teller");
       if(this.homeSteps.isInHomePage()){
           ExtentReporter.logPass("loginValid","Login Successful");
       }
    }

}
