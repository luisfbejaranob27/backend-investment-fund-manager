package co.luisfbejaranob.backend.investment.fund.manager.shared.utils;

import java.lang.reflect.Field;

public class ObjectUtil
{
    public static <T> T updateValues(T target, T source) throws IllegalAccessException
    {
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null) {
                field.set(target, value);
            }
        }

        return target;
    }
}
