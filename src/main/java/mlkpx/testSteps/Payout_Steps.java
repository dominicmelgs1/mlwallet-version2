package mlkpx.testSteps;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.error.YAMLException;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Payout_Steps extends Base_Steps{

    //P A Y O U T    T R A N S A C T I O N
    // todo
    //  use method in yamlReader to retrieve random KPTN
    //  use method in yamlReader to retrieve random KYC
    //  parameterize test data for branch code
    //  add Assert.fail() for failed tc
    //  optimize code ** create method for common steps such as searching kyc and etc ** to reuse again.

    public void navigatePayoutPage()throws Exception{

            click(payoutPageObjects.payout_link(), "Payout");
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to Payout Page");
            }
    }
    public void validateSuccessfulDomesticPayout()throws Exception{
            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            waitSleep(3000);
            //todo
            String sendoutKPTN = reader.getPayoutKPTN(); // Call the getPayoutKPTN method
            type(payoutPageObjects.PayKTPN(), "KTPN", sendoutKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            click(payoutPageObjects.SearchButton(), "Search Button");
            waitSleep(2);
            click(payoutPageObjects.SearchKYC(), "Search KYC");
            waitSleep(2);
            payoutPageObjects.SearchLName().clear();
            // todo
            String[] randomName = reader.getRandomName();
            type(payoutPageObjects.SearchLName(), "Last name field", randomName[1]);
            payoutPageObjects.SearchFName().clear();
            type(payoutPageObjects.SearchFName(), "First name field", randomName[0]);
            payoutPageObjects.SearchMName().clear();
            type(payoutPageObjects.SearchMName(), "Middle name field", "");
            click(payoutPageObjects.SearchKYCAc(), "Search Button");
            waitSleep(2);
            click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
            waitSleep(2);
            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to View KYC");
                scrollDown(100);
                waitSleep(3000);
                scrollDown(100);
            }
            click(payoutPageObjects.SelectKYC(), "Select KYC");
            if (payoutPageObjects.KtpnInfo().getText().contains("KPTN")) {
                click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            }
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            if (payoutPageObjects.SuccessfulPay().getText().contains("Payout Successful")) {
                assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                List<String> payoutKPTNList = Collections.singletonList(sendoutKPTN);
                reader.writePayoutKptnData(payoutKPTNList);
            }
            click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
            click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
    }



    public void validateSuccessfulRemoteDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            //todo
            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            waitSleep(3000);
            String sendoutRemoteKPTN = reader.getRemoteKPTN(); // Call the getSendOutRemoteKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN Number", sendoutRemoteKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            click(payoutPageObjects.SearchButton(), "Search Button");
            waitSleep(2);
            click(payoutPageObjects.SearchKYC(), "Search KYC");
            waitSleep(2);
            payoutPageObjects.SearchLName().clear();
            String[] randomName = reader.getRandomName();
            type(payoutPageObjects.SearchLName(), "Last name field", randomName[1]);
            payoutPageObjects.SearchFName().clear();
            type(payoutPageObjects.SearchFName(), "First name field", randomName[0]);
            payoutPageObjects.SearchMName().clear();
            type(payoutPageObjects.SearchMName(), "Middle name field", "");
            click(payoutPageObjects.SearchKYCAc(), "Search Button");
            waitSleep(2);
            click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
            waitSleep(2);

            if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
                LoggingUtils.info("Navigated to View KYC");
                scrollDown(100);
                waitSleep(3000);
                scrollDown(100);
            }
            click(payoutPageObjects.SelectKYC(), "Select KYC");
            if (payoutPageObjects.KtpnInfo().getText().contains("KPTN")) {

                click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
            }

            if (payoutPageObjects.PayoutConfirm().isEnabled()) {
                    click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");

                    if (getText(payoutPageObjects.SuccessfulPay()).equals("Payout Successful")) {
                        assertEqual(getText(payoutPageObjects.SuccessfulPay()), "Payout Successful");
                        List<String> payoutremoteKPTNList = Collections.singletonList(sendoutRemoteKPTN);
                        reader.writeRemotePayoutKptnData(payoutremoteKPTNList);

                    }
                    click(payoutPageObjects.proceedToPrinting(), "Proceed to Printing");
                    waitSleep(2000);
                    click(payoutPageObjects.cancelButtoninReceipt(), "Cancel Button Receipt");
                }

            }

    public void validateComplianceAssistance()throws Exception{

        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        type(payoutPageObjects.PayKTPN(), "Compliance KTPN Number", propertyReader.getproperty("ComplianceAssKTPN"));
        type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("UnPayAmount"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitSleep(2);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitSleep(2);
        payoutPageObjects.SearchLName().clear();
        type(payoutPageObjects.SearchLName(), "Last name field", "SIAROT");
        payoutPageObjects.SearchFName().clear();
        type(payoutPageObjects.SearchFName(), "First name field", "ENRIQUE");
        payoutPageObjects.SearchMName().clear();
        type(payoutPageObjects.SearchMName(), "Middle name field", "");
        click(payoutPageObjects.SearchKYCAc(), "Search Button");
        waitSleep(2);
        click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2);
        if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.PayoutInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Payout Information's");
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
        }

        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            WebDriverWait ca = new WebDriverWait(driver, Duration.ofSeconds(10));
            ca.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OKCom()));
            assertEqual(getText(payoutPageObjects.ComplianceAss()), "For Compliance Assistance");
            click(payoutPageObjects.OKCom(), "Click OK");

        }


    }
    public void validateRemoteComplianceAssistance()throws Exception{

        click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
        click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

        type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
        type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
        type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

        click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
        type(payoutPageObjects.PayKTPN(), "Compliance KTPN Number", propertyReader.getproperty("ComplianceAssKTPN"));
        type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("UnPayAmount"));
        click(payoutPageObjects.SearchButton(), "Search Button");
        waitSleep(2);
        click(payoutPageObjects.SearchKYC(), "Search KYC");
        waitSleep(2);
        payoutPageObjects.SearchLName().clear();
        type(payoutPageObjects.SearchLName(), "Last name field", "SIAROT");
        payoutPageObjects.SearchFName().clear();
        type(payoutPageObjects.SearchFName(), "First name field", "ENRIQUE");
        payoutPageObjects.SearchMName().clear();
        type(payoutPageObjects.SearchMName(), "Middle name field", "");
        click(payoutPageObjects.SearchKYCAc(), "Search Button");
        waitSleep(2);
        click(payoutPageObjects.ViewKYCCustomer(), "View KYC");
        waitSleep(2);
        if(isVisible(payoutPageObjects.payoutPage_h2(), getText(payoutPageObjects.payoutPage_h2()))){
            LoggingUtils.info("Navigated to View KYC");
            scrollDown(100);
            waitSleep(3000);
            scrollDown(100);
        }
        click(payoutPageObjects.SelectKYC(), "Select KYC");
        if (payoutPageObjects.PayoutInfos().isEnabled()) {
            LoggingUtils.info("Navigated to View Payout Information's");
            click(payoutPageObjects.ClaimAmount(), "Select Claim Amount");
        }
        if (payoutPageObjects.PayoutConfirm().isEnabled()) {
            click(payoutPageObjects.ConfirmPayout(), "Click Confirm Payout");
            WebDriverWait ca = new WebDriverWait(driver, Duration.ofSeconds(10));
            ca.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OKCom()));
            assertEqual(getText(payoutPageObjects.ComplianceAss()), "For Compliance Assistance");
            click(payoutPageObjects.OKCom(), "Click OK");
        }
    }
    public void validateInvalidKTPN()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("InvalidKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");

            if(isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.payoutPage_h5()))){
                assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");
    }
    public void validateRemoteInvalidKTPN()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("InvalidKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");

            if (isVisible(payoutPageObjects.InvalidKTPN(), getText(payoutPageObjects.payoutPage_h5()))) {
                assertEqual(getText(payoutPageObjects.payoutPage_h5()), "No Transaction Found");
            }
            click(payoutPageObjects.OKInvalidKTPN(), "OK");
    }
    public void validateInvalidAmountDPT()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("UnclaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("InvalidAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.InvalidAmount()), "Amount entered does not match amount in KPTN / reference no.");
    }
    public void validateInvalidAmountRemoteDPT()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");

            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("UnclaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("InvalidAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.InvalidAmount()), "Amount entered does not match amount in KPTN / reference no.");
    }
    public void validateClaimedDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            String payoutKPTN = reader.getSuccessPayoutKPTN(); // Call the getPayoutKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN Number", payoutKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutClaim_h5()), "No Transaction Found");
    }
    public void validateClaimedRemoteDomesticPayout()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            String remotePayoutKPTN = reader.getSuccessRemotePayoutKPTN(); // Call the getRemotePayoutKPTN function
            type(payoutPageObjects.PayKTPN(), "KTPN Number", remotePayoutKPTN);
            type(payoutPageObjects.PayAmount(), "Amount", "100");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.payoutClaim_h5()), "No Transaction Found");
    }
    public void validateDPTwithoutKTPNInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", "");
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.RequiredKTPN()), "KPTN is required");
    }
    public void validateRemoteDPTwithoutKTPNInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", "");
            payoutPageObjects.PayAmount().clear();
            type(payoutPageObjects.PayAmount(), "Amount", propertyReader.getproperty("PayAmount"));
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.RequiredKTPN()), "KPTN is required");
    }
    public void validateDPTwithoutAmountInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.UnremoteTransaction(), "Un-remote Transaction");
            click(payoutPageObjects.DomesticTransaction(), "Domestic Transaction");
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("ClaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", "");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.AmountShouldBeNumber()), "Amount should be a number");
    }
    public void validateRemoteDPTWithoutAmountInput()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "2023639709");
            type(payoutPageObjects.ReasonRemote(), "Reason", "Testing");
            waitSleep(4);
            type(payoutPageObjects.PayKTPN(), "KTPN Number", propertyReader.getproperty("ClaimKTPNnum"));
            type(payoutPageObjects.PayAmount(), "Amount", "");
            click(payoutPageObjects.SearchButton(), "Search Button");
            assertEqual(getText(payoutPageObjects.AmountShouldBeNumber()), "Amount should be a number");
    }
    public void validateRemoteInvalidBranchCode()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));

            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R3180912");
            ExtentReporter.logPass("validateRemoteInvalidBranchCode","Branch not found");


    }
    public void validateRemoteInvalidOperatorID()throws Exception{

            click(payoutPageObjects.PayoutTransaction(), "Payout Transaction");
            click(payoutPageObjects.RemoteTransaction(), "Remote Transaction");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.BranchCode()));
            payoutPageObjects.BranchCode().clear();
            type(payoutPageObjects.BranchCode(), "Search Branch Code", "12R33A180912");
            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

            waits.until(ExpectedConditions.elementToBeClickable(payoutPageObjects.OperatorID()));
            type(payoutPageObjects.OperatorID(), "Search Operator ID", "20236709");
            ExtentReporter.logPass("validateRemoteInvalidOperatorID","Operator not found");
    }
}






