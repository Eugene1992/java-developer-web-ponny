package com.cbsystematics.edu.jdbc.utils.reflectionUtils.annotationUtils;

import java.lang.annotation.Annotation;
import java.util.HashMap;

//todo remove not used methods
public class AnnotationParser {

    public static boolean isAnnotationPresent(Object object, Class clazz) {
        return (object.getClass().getAnnotation(clazz) != null);
    }

    public static Annotation[] getAllClassAnnotations(Object object) {
        return object.getClass().getAnnotations();
    }

    private String[] getAnnotationNames(Object object) {
        String[] allAnnotationNames = new String[getAllClassAnnotations(object).length];
        return null;
    }

    private static String getAnnotationSimpleNameAndValues(Annotation annotation) {
        String fullAnnotationName = annotation.toString();

        String[] fullAnnotationNameParts = fullAnnotationName.split("([.])");

        return fullAnnotationNameParts[fullAnnotationNameParts.length - 1];
    }

    private static String[] getAnnotationElements(Annotation annotation) {
        return getAnnotationSimpleNameAndValues(annotation).split("([()])");
    }

    public static String getAnnotationName(Annotation annotation) {
        return getAnnotationElements(annotation)[0];
    }

    private static HashMap<String, String> getAnnotationFields(Annotation annotation) {
        HashMap<String, String> annotationMap = new HashMap<>();
        String[] allAnnotationFields = getAnnotationElements(annotation)[1].split(",");

        for (String allAnnotationField : allAnnotationFields) {
            String[] annotationFieldAndValue = allAnnotationField.split("=");
            annotationMap.put(annotationFieldAndValue[0], annotationFieldAndValue[1]);
        }

        return annotationMap;
    }

}
