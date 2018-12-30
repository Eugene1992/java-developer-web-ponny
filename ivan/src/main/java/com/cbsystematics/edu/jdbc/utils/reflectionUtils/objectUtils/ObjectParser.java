package com.cbsystematics.edu.jdbc.utils.reflectionUtils.objectUtils;

import com.cbsystematics.edu.jdbc.annotations.Column;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ObjectParser {

    public static ArrayList<Field> getObjectFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void setAllFieldsAccessible(Object object) {
        getObjectFields(object).stream()
                .peek(field -> field.setAccessible(true));
    }

    public static HashMap<String, Object> getFieldsAnnotatedNameAndValuesMap(Object object) {
        HashMap<String, Object> nameAndValuesMap = new HashMap<>();

        setAllFieldsAccessible(object);
        getObjectFields(object).stream()
                .filter(field -> field.getAnnotation(Column.class) != null)
                .peek(field -> field.setAccessible(true))
                .forEach(field -> {
                    try {
                        nameAndValuesMap.put(
                                field.getAnnotation(Column.class).name(),
                                field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return nameAndValuesMap;
    }
}
