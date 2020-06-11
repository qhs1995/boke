
package com.hongshen.boke.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象属性复制工具类,采用javassit生成源代码实现属性复制.并能实现包装类型和基础类型之间的转换 <h3>Usage Examples</h3>
 *
 */
public class BeanUtil extends BeanUtils {
    /**
     * 复制对象属性，属性名需一致
     *
     * @param from 源对象
     * @param to 目标对象
     */
    public static void copy(Object from, Object to) {
        BeanUtils.copyProperties(from, to);
    }

    /**
     * 复制对象属性
     *
     * @param from 源对象
     * @param to   目标对象类型
     * @param <T>
     * @return
     */
    public static <T> T copy(Object from, Class<T> to) {
        try {
            T obj = to.newInstance();
            BeanUtils.copyProperties(from, obj);
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("BeanUtil.copy error:", e);
        }
    }

    /**
     * 复制对象属性
     *
     * @param fromList 源对象数组
     * @param to       目标对象类型
     * @param <T>
     * @return
     */
    public static <T> List<T> copy(List<?> fromList, Class<T> to) {
        List<T> toList = new ArrayList<>();
        fromList.forEach(o -> {
            try {
                T obj = to.newInstance();
                toList.add(obj);
                BeanUtils.copyProperties(o, obj);
            } catch (Exception e) {
                throw new RuntimeException("BeanUtil.copy error:", e);
            }
        });
        return toList;
    }
}