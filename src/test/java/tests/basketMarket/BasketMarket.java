package tests.basketMarket;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BasketMarket extends BaseTest {
  @Test
  public void testMakingAnOrderByPickUpByWriteScore() throws Exception {
   autorization.enterLoginPassword();
  }
  @Test
  public void testMakingAnOrderByCDEKPayUponReceipt() throws Exception{
    autorization
            .enterLoginPassword();
    estimateMarket
            .AddEstimateToBasket();
  }

}
