package activity;

import com.liyueze.activity.StrategyActivity;
import com.liyueze.common.CashBackPromotion;

/**
 * 这种实现方式是策略模式最常见的实现方式，对于客户端来说每种策略客户端是知道的，客户端自己选择需要的策略
 */

public class ActivityTest {
    public static void main(String[] args) {
        StrategyActivity strategyActivity=new StrategyActivity(new CashBackPromotion());
        strategyActivity.doStrategy();
    }
}
