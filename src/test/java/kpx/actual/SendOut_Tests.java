package kpx.actual;

import kpx.base.BaseTest;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReporter;

public class SendOut_Tests extends BaseTest {
    @Test(description = "Logging in via gmail and kpx")
    public void loginGoogle() throws Exception {
        this.loginSteps.signInGoogle("teller");
        this.loginSteps.loginKpx("teller");
        if (this.homeSteps.isInHomePage()) {
            ExtentReporter.logPass("loginGoogle", "Login, Passed!!");
        }
    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 1, description = "Verify Navigation of SendOut Domestic")
//    public void DS_TC_01()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_01();
//        }
//    }
//
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 2, description = "Verify SendOut Transaction Option Invalid Branch Code")
//    public void DS_TC_02()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_02();
//        }
//    }
//
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 3, description = "Verify SendOut Transaction Option Valid Branch Code")
//
//        public void DS_TC_02_1()throws Exception{
//            if(this.homeSteps.isInHomePage()){
//                this.sendOutSteps.DS_TC_02_1();
//            }
//        }
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 4, description = "Verify Search KYC (Sender)")
//    public void DS_TC_03()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_03();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 5, description = "Verify Search KYC (Sender) Negative Test")
//    public void DS_TC_03_1()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_03_1();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle" , priority = 6, description = "Verify Add Receiver New")
//    public void DS_TC_04()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_04();
//        }
//    }
//    @Test(dependsOnMethods = "loginGoogle" , priority = 7, description = "Verify Add Receiver New Negative Test")
//    public void DS_TC_04_1()throws Exception{
//        if(this.homeSteps.isInHomePage()){
//            this.sendOutSteps.DS_TC_04_1();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 8, description = "Verify Search Receivers")
//    public void DS_TC_05() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_05();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 9, description = "Verify Other Information Inputs")
//    public void DS_TC_06() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_06();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 10, description = "Verify Principal Amount")
//    public void DS_TC_07() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_07();
//        }
//    }

    @Test(dependsOnMethods = "loginGoogle", priority = 12, description = "To Validate Submit SendOut Transaction")

    public void DS_TC_8() throws Exception {
        if (this.homeSteps.isInHomePage()) {
            this.sendOutSteps.DS_TC_08();
        }
    }


//    @Test(dependsOnMethods = "loginGoogle", priority = 11, description = "To Validate Cancel SendOut Transaction")
//    public void DS_TC_09() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_09();
//        }
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 13, description = "To Validate Cancel No SendOut Transaction")
//    public void DS_TC_10() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_10();
//        }
//
//    }
//
//    @Test(dependsOnMethods = "loginGoogle", priority = 14, description = "To Validate kyc from the Watch List")
//    public void DS_TC_11() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_11();
//        }
//
//    }
//    @Test(dependsOnMethods = "loginGoogle", priority = 15, description = "To Validate The Same Transaction")
//    public void DS_TC_12() throws Exception {
//        if (this.homeSteps.isInHomePage()) {
//            this.sendOutSteps.DS_TC_12();
//        }
//
//    }

}


