package com.cbsystematics.edu.jdbc.utils.dataBaseUtils;

import com.cbsystematics.edu.jdbc.annotations.Column;
import com.cbsystematics.edu.jdbc.annotations.Table;
import com.cbsystematics.edu.jdbc.utils.reflectionUtils.annotationUtils.AnnotationParser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseElementsParser {
    private Object objectToParse;

    private String tableName;
    private ArrayList<String> tableColumns;

    public DataBaseElementsParser(Object objectToParse) {
        this.objectToParse = objectToParse;
        setTableName();
        setTableColumns();
    }

    private void setTableName() {
        if(AnnotationParser.isAnnotationPresent(objectToParse, Table.class)) {
            tableName =  objectToParse.getClass().getAnnotation(Table.class).name();
        }
    }

    public  String getTableName() {
        return tableName;
    }

    public void setTableColumns() {
        List<Field> allDeclaredFields = Arrays.asList(objectToParse.getClass().getDeclaredFields());

        tableColumns = allDeclaredFields.stream()
                .filter(field -> field.getAnnotation(Column.class) != null)
                .map(field -> field.getAnnotation(Column.class).name())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getTableColumns() {
        return tableColumns;
    }
}
