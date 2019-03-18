package com.liyueze.serialize.hungrySingleton;

import com.liyueze.hungry.HungrySingleton;
import com.liyueze.serialize.common.SerializeUtil;

public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        SerializeUtil.serialize(hungrySingleton);
        /**
         * 结果输出：
         * com.liyueze.hungry.HungrySingleton@340f438e
         * com.liyueze.hungry.HungrySingleton@4520ebad
         * false
         *
         * 结论：已经破坏单例
         * 为防止序列化破坏单例举措：
         * 1.单例对象不可序列化（不实现 Serializable接口）
         * 2.自己实现readResolve方法（实现见HungrySingleton类中）
         *   2.1：原因：见ObjectInputStream中的readOrdinaryObject方法
         *         代码片段：
         *
         *         if (obj != null &&
         *             handles.lookupException(passHandle) == null &&
         *             desc.hasReadResolveMethod())
         *         {
         *             Object rep = desc.invokeReadResolve(obj);//这里invoke了ReadResolve
         *             if (unshared && rep.getClass().isArray()) {
         *                 rep = cloneArray(rep);
         *             }
         *             if (rep != obj) {
         *                 // Filter the replacement object
         *                 if (rep != null) {
         *                     if (rep.getClass().isArray()) {
         *                         filterCheck(rep.getClass(), Array.getLength(rep));
         *                     } else {
         *                         filterCheck(rep.getClass(), -1);
         *                     }
         *                 }
         *                 handles.setObject(passHandle, obj = rep);//将obj重新赋值为ReadResolve的返回值
         *             }
         *         }
         *         return obj;//返回的对象
         *
         *  2.2：但在jdk层面已经创建了两个单例对象，只是重新赋值而已
         *      代码片段（ObjectInputStream中的readOrdinaryObject方法）
         *
         *      Object obj;
         *         try {
         *             obj = desc.isInstantiable() ? desc.newInstance() : null;//这里就被创建了
         *         } catch (Exception ex) {
         *             throw (IOException) new InvalidClassException(
         *                 desc.forClass().getName(),
         *                 "unable to create instance").initCause(ex);
         *         }
         *
         *     注意：上面的代码片段在2.1的原因代码片段之前，意味着jdk已经创建了一个对象，只是后来覆盖而已
         */
    }
}
