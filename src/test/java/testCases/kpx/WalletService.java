package testCases.kpx;

import base.BaseTest;
import org.testng.annotations.Test;

public class WalletService extends BaseTest {

    @Test(priority = 1 ,description = "Test to get cash in KPTN")
    public void cashIn(){
        loginWalletSteps.loginWallet();
        cashInSteps.cashIn();
    }

    @Test(priority = 2 ,description = "Test to get KwartaPadala KPTN")
    public void kwartaPadala(){
        loginWalletSteps.loginWallet();
        kwartaPadala.kwartaPadala();
    }

    @Test(priority = 3 ,description = "Test to get CashOut KPTN")
    public void cashOut(){
        loginWalletSteps.loginWallet();
        cashOut.cashOut();
    }

}

