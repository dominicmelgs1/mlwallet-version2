package steps.mlwallet;

import java.util.Collections;
import java.util.List;

public class Kwarta_Padala extends Base_Steps{
    public void kwartaPadala() {
        mobileGeneralMethod.waitSleep(2000);
        mobileGeneralMethod.tap(mlWalletPageObjects.sendMoney_icon(), "Send Money Icon");
        mobileGeneralMethod.tap(mlWalletPageObjects.sendMoney_branchOption(), "Send Money Via Branch");
        mobileGeneralMethod.tap(mlWalletPageObjects.savedRecipient_kp(), "Saved Recipients");
        mobileGeneralMethod.waitSleep(5000);
        mobileGeneralMethod.tap(mlWalletPageObjects.firstRecipient_kp(), "First Recipient");
        mobileGeneralMethod.tap(mlWalletPageObjects.selectRecipient_button(), "Select Recipient");
        mobileGeneralMethod.waitSleep(2000);
        mobileGeneralMethod.tap(mlWalletPageObjects.noMiddleName_button(), "No MiddleName");
        mobileGeneralMethod.tap(mlWalletPageObjects.next_next(), "Next Button");
        mobileGeneralMethod.type(mlWalletPageObjects.amountEditText(), "Amount Edit Text", "100");
        mobileGeneralMethod.tap(mlWalletPageObjects.next_btn(), "Next Button");
        mobileGeneralMethod.tap(mlWalletPageObjects.selectPayment_Wallet(), "Wallet Payment");
        mobileGeneralMethod.waitSleep(8000);
        mobileGeneralMethod.tap(mlWalletPageObjects.confirm_Btn(), "Confirm btn");
        mobileGeneralMethod.waitSleep(12000);
        mobileGeneralMethod.tap(mlWalletPageObjects.continue2_btn(), "OTP Continue");
        mobileGeneralMethod.waitSleep(12000);
        mobileGeneralMethod.verticalSwipe();

        mobileGeneralMethod.isVisible(mlWalletPageObjects.kwartaPadala_KPTN(), mlWalletPageObjects.kwartaPadala_KPTN().getText());
        String kptnText = (mlWalletPageObjects.kwartaPadala_KPTN().getText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        yamlReader.writeKP_Kptn(kptnValues);
        mobileGeneralMethod.tap(mlWalletPageObjects.BacktoHome(), "Back To Home");


    }
}
