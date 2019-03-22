package com.liyueze.serialize.lazySingleton;

import com.liyueze.lazy.LazyInnerClassSingleton;
import com.liyueze.lazy.LazySimpleSingleton;
import com.liyueze.serialize.common.SerializeUtil;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        LazyInnerClassSingleton lazyInnerClassSingleton=LazyInnerClassSingleton.getInstance();
        SerializeUtil.serialize(lazyInnerClassSingleton);
    }
}
