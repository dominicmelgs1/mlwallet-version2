package base;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import steps.kpx.Login_Steps;
import steps.mlwallet.Cash_In;
import steps.mlwallet.Cash_Out;
import steps.mlwallet.Kwarta_Padala;
import steps.mlwallet.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static utilities.Driver.DriverManager.*;

import utilities.Driver.AppiumDriverManager;
import utilities.Driver.DriverType;

import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;

import java.time.Duration;

public class BaseTest {
    protected Home_Steps homeSteps;
    protected Login_Steps loginSteps;
    protected Kyc_Steps kycSteps;
    protected SendOut_Steps sendOutSteps;
    protected SendOutCancellation_Steps sendOutCancellationSteps;
    protected Payout_Steps payoutSteps;
    protected PayoutCancellation_Steps payoutCancellationSteps;
    protected PayoutReprinting_Steps payoutReprintingSteps;
    protected BillsPay_Steps billsPaySteps;
    protected BillsPayCancellation_Steps billsPayCancellationSteps;
    protected BillsPayChangeD_Steps billsPayChangeDSteps;
    protected BillsPayReprinting_Steps billsPayReprintingSteps;
    protected SOReprinting_Steps soReprintingSteps;
    protected RequestForChange_Steps requestForChangeSteps;
    protected ReturnToSender_Steps returnToSenderSteps;
    protected ORReprinting_Steps orReprintingSteps;
    protected WS_CashInToOwnAccount_Steps wsCashInToOwnAccountSteps;
    protected WS_CashInToAnotherAccount wsCashInToAnotherAccount;
    protected WS_CashOut_Steps wsCashOutSteps;
    protected WS_KwartaPadalaPayOut_Steps wsKwartaPadalaPayOutSteps;
    protected WS_Reprinting_Steps wsReprintingSteps;
    protected WS_ShopSafe_Steps wsShopSafeSteps;

    protected SendOutTransactional_Steps sendOutTransactionalSteps;
    protected SendOutNegativeTest_Steps sendOutNegativeTestSteps;

    protected Login loginWalletSteps;
    protected Cash_In cashInSteps;


    protected Kwarta_Padala kwartaPadala;
    protected Cash_Out cashOut;


    @Parameters("type")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String type){
        if(type.equals("mobile")){
//            AppiumDriverManager.setupServer();
//            AppiumDriverManager.startActivity();
//            initWallet();
        }else if(type.equals("web")){
            final String browser ="chrome";
            initializeDriver(DriverType.valueOf(browser.toUpperCase()));
            getDriver().manage().deleteAllCookies();
            getDriver().get(System.getProperty("targetUrl"));
            init();
        }else{
            throw new AssertionError("Unsupported Type: " + type);
        }
        ExtentReporter.setPlatform(type);

    }
    private void initializeDriver(DriverType driverType) {
        createDriver(driverType);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("type")
    public void setUpTests(final String type){
        if(type.equals("web")) {
            getDriver().get(System.getProperty("homeUrl"));
        }else if(type.equals("mobile")){
            LoggingUtils.info("Starting app...");
            AppiumDriverManager.setupServer();
            AppiumDriverManager.startActivity();
            initWallet();
            PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverManager.getAndroidDriver(), Duration.ofSeconds(10)), this);
        }
    }
    @AfterMethod(alwaysRun = true)
    @Parameters("type")
    public void clean(final String type){
        if(type.equals("mobile")) {
//            LoggingUtils.info("Resetting app...");
            AppiumDriverManager.stopServer();
        }
        LoggingUtils.info("------>>>Test Ended<<<-------");
    }
    @AfterClass(alwaysRun = true)
    @Parameters("type")
    public void tearDown (final String type) {
        if(type.equals("mobile")){
//            AppiumDriverManager.stopServer();
        }else if(type.equals("web")){
            closeWebBrowser();
        }else{
            throw new IllegalArgumentException("Unsupported Type: " + type);
        }
    }
    public void init(){
        this.loginSteps = new Login_Steps();
        this.homeSteps = new Home_Steps();
        this.kycSteps = new Kyc_Steps();
        this.sendOutSteps = new SendOut_Steps();
        this.sendOutCancellationSteps = new SendOutCancellation_Steps();
        this.payoutSteps = new Payout_Steps();
        this.payoutCancellationSteps = new PayoutCancellation_Steps();
        this.payoutReprintingSteps = new PayoutReprinting_Steps();
        this.billsPaySteps = new BillsPay_Steps();
        this.billsPayCancellationSteps = new BillsPayCancellation_Steps();
        this.billsPayChangeDSteps = new BillsPayChangeD_Steps();
        this.billsPayReprintingSteps = new BillsPayReprinting_Steps();
        this.soReprintingSteps = new SOReprinting_Steps();
        this.requestForChangeSteps = new RequestForChange_Steps();
        this.returnToSenderSteps = new ReturnToSender_Steps();
        this.orReprintingSteps = new ORReprinting_Steps();
        this.wsCashInToOwnAccountSteps = new WS_CashInToOwnAccount_Steps();
        this.wsCashInToAnotherAccount = new WS_CashInToAnotherAccount();
        this.wsCashOutSteps = new WS_CashOut_Steps();
        this.wsKwartaPadalaPayOutSteps = new WS_KwartaPadalaPayOut_Steps();
        this.wsReprintingSteps = new WS_Reprinting_Steps();
        this.wsShopSafeSteps = new WS_ShopSafe_Steps();

        this.sendOutTransactionalSteps = new SendOutTransactional_Steps();
        this.sendOutNegativeTestSteps = new SendOutNegativeTest_Steps();


    }
    public void initWallet(){
        this.loginWalletSteps = new Login();
        this.cashInSteps = new Cash_In();
        this.kwartaPadala = new Kwarta_Padala();
        this.cashOut = new Cash_Out();
    }
}