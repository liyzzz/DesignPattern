package generalClient;

import com.liyueze.general.GeneralStrategyClient;

public class GeneralClientTest {
    public static void main(String[] args) {
        String promotionKey="VIP";
        GeneralStrategyClient.strategyFactory(promotionKey);
    }
}
