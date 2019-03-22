package com.liyueze.serialize.lazySingleton;

import com.liyueze.lazy.LazySimpleSingleton;
import com.liyueze.serialize.common.SerializeUtil;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        LazySimpleSingleton lazySimpleSingleton=LazySimpleSingleton.getInstance();
        SerializeUtil.serialize(lazySimpleSingleton);
    }
}
