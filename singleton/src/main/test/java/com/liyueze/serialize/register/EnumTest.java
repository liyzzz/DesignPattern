package com.liyueze.serialize.register;

import com.liyueze.lazy.EnumSingleton;
import com.liyueze.serialize.common.SerializeUtil;

public class EnumTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton=EnumSingleton.getInstance();
        SerializeUtil.serialize(enumSingleton);
    }
}
/**
 * 结果：
 * INSTANCE
 * INSTANCE
 * true
 * 解释：
 * 在jdk层面就为enum的单例保驾护航
 * 代码片段（jdk的ObjectInputStream类的readEnum方法）：
 * String name = readString(false);
 *         Enum<?> result = null;
 *         Class<?> cl = desc.forClass();
 *         if (cl != null) {
 *             try {
 *                 @SuppressWarnings("unchecked")
 *                 Enum<?> en = Enum.valueOf((Class)cl, name);//可以看到在jdk层面，反序列化的过程中不会创建新的enum
 *                 result = en;
 *             } catch (IllegalArgumentException ex) {
 *                 throw (IOException) new InvalidObjectException(
 *                     "enum constant " + name + " does not exist in " +
 *                     cl).initCause(ex);
 *             }
 *             if (!unshared) {
 *                 handles.setObject(enumHandle, result);
 *             }
 *         }
 */
