package activity;

import com.liyueze.activity.StrategyActivity;
import com.liyueze.common.CashBackPromotion;

/**
 * 这种实现方式是策略模式最常见的实现方式，对于客户端来说每种策略客户端是知道的，客户端自己选择需要的策略
 */

/**
 * 装饰器模式和策略模式都是持有引用，看起来实现类似。
 * 但是装饰器模式关注的是对引用的包装（扩展）
 * 而策略模式关注的是传递过来的引用（策略）执行的方法
 */

public class ActivityTest {
    public static void main(String[] args) {
        StrategyActivity strategyActivity = new StrategyActivity(new CashBackPromotion());
        strategyActivity.doStrategy();
    }
}
