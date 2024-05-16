package steps.kpx;

import pageObj.mlkpx.Google_PageObjects;
import pageObj.mlkpx.Home_PageObjects;
import pageObj.mlkpx.Login_PageObjects;
import utilities.ReusableComponents.GeneralMethod;
import utilities.PropertyReader.propertyReader;
import org.testng.Assert;
public abstract class Base_Steps extends GeneralMethod {

    Kyc_PageObjects kycPageObjects = new Kyc_PageObjects();
    Home_PageObjects homePageObjects = new Home_PageObjects();
    Login_PageObjects loginPageObjects = new Login_PageObjects();
    Google_PageObjects googlePageObjects = new Google_PageObjects();
    SendOut_PageObjects sendOutPageObjects = new SendOut_PageObjects();
    SendOutCancellation_PageObjects sendOutCancellationPageObjects = new SendOutCancellation_PageObjects();
    SOReprinting_PageObjects soReprintingPageObjects = new SOReprinting_PageObjects();
    RequestForChange_PageObjects requestForChangePageObjects = new RequestForChange_PageObjects();
    ReturnToSender_PageObjects returnToSenderPageObjects = new ReturnToSender_PageObjects();
    ORReprinting_PageObjects orReprintingPageObjects = new ORReprinting_PageObjects();
    WalletServices_PageObjects walletServicesPageObjects = new WalletServices_PageObjects();
    BillsPay_PageObjects billsPayPageObjects = new BillsPay_PageObjects();
    Payout_PageObjects payoutPageObjects = new Payout_PageObjects();
    PayoutCancellation_PageObjects payoutCancellationPageObjects = new PayoutCancellation_PageObjects();
    PayoutReprinting_PageObjects payoutReprintingPageObjects = new PayoutReprinting_PageObjects();
    WS_CashInToOwnAccount_PageObjects wsCashInToOwnAccountPageObjects = new WS_CashInToOwnAccount_PageObjects();
    WS_CashOut_PageObjects wsCashOutPageObjects = new WS_CashOut_PageObjects();
    WS_KwartaPadalaPayOut_PageObjects wsKwartaPadalaPayOutPageObjects = new WS_KwartaPadalaPayOut_PageObjects();
    WS_ShopSafe_PageObjects wsShopSafePageObjects = new WS_ShopSafe_PageObjects();
    final String filepath = "src\\test\\java\\resources\\testData.properties";
    propertyReader propertyReader = new propertyReader(filepath);
    Assert anAssert;
}
