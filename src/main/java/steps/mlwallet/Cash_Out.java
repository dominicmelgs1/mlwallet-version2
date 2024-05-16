package steps.mlwallet;

import java.util.Collections;
import java.util.List;

public class Cash_Out extends Base_Steps{
    public void  cashOut(){
        mobileGeneralMethod.waitSleep(2000);
        mobileGeneralMethod.tap(mlWalletPageObjects.cashOut_icon(), "Withdraw Icon");
        mobileGeneralMethod.tap(mlWalletPageObjects.cashOut_MLBranch(), "Cash Out to any ML Branch");
        mobileGeneralMethod.waitSleep(5000);
        mobileGeneralMethod.type(mlWalletPageObjects.amountEditText(), "Amount Edit Text", "100");
        mobileGeneralMethod.tap(mlWalletPageObjects.next_next(), "Next Button");
        mobileGeneralMethod.waitSleep(8000);
        mobileGeneralMethod.tap(mlWalletPageObjects.ContinueToCashOut(), "Continue btn");
        mobileGeneralMethod.waitSleep(20000);
        mobileGeneralMethod.tap(mlWalletPageObjects.continue2_btn(), "OTP Continue");
        mobileGeneralMethod.waitSleep(15000);
        mobileGeneralMethod.isVisible(mlWalletPageObjects.CashOut_KPTN(), mlWalletPageObjects.CashOut_KPTN().getText());

        String kptnText = (mlWalletPageObjects.CashOut_KPTN().getText());
        List<String> kptnValues = Collections.singletonList(kptnText);
        yamlReader.writeCashOut_Kptn(kptnValues);
        mobileGeneralMethod.tap(mlWalletPageObjects.BacktoHome(), "Back To Home");
    }
}
