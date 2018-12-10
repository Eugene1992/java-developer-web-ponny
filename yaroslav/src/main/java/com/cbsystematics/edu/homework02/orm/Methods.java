package com.cbsystematics.edu.homework02.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {


    public static final String DELETE_QUERY_TEMPLATE = "DELETE FROM %s WHERE %s = %s";
    public static final String INSERT_QUERY_TEMPLATE = "INSERT INTO %s(%s) VALUES(%s)";

    /**---------------------------------------------GetAll------------------------------------------/

    /**
     * Метод, для создания универсального sql запроса для метода getAll
     */
    public static <T> String getSqlQueryGetAll(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        String sql = "SELECT * FROM ";
        T t =  clazz.newInstance();
        sql += getTableName(t);
        return sql;
    }


    /**
     * Метод, который записывает все значения полученые из ResultSet в поля обьекта
     */
    public static <T> void setAllValuesToFields(T t, ResultSet resultSet) throws SQLException, IllegalAccessException {
        List<Field> fields = Arrays.asList(t.getClass().getDeclaredFields());
        Methods.addArrayToList(fields, t.getClass().getSuperclass().getDeclaredFields());
        for (Field field : fields) {
            Object columnValue = Methods.getColumnValue(field, resultSet);
            field.set(t, columnValue);
        }
    }





    /**--------------------------------------------Create--------------------------------------------/

    /**
     * Метод, для создания универсального sql запроса для метода create()
     */
    public static <T> String getSqlQueryForCreate(T t) throws IllegalAccessException {
        String sql = "INSERT INTO ";
        sql += getTableName(t) + getColumnNamesInQuery(t) + getColumnValuesInQuery(t);
        return sql;
    }

    /**
     * Метод, который заносит в запрос на создание элемента имена колонок таблицы
     */
    public static <T> String getColumnNamesInQuery(T t) {
        Class clazz = t.getClass();
        String result = "(";
        int counter = clazz.getDeclaredFields().length;
        for (Field field : clazz.getDeclaredFields()) {
            counter--;
            String fieldName = Methods.getColumnNameFromAnnotation(field);
            result += fieldName;
            if (counter != 0) { // TODO: 10.12.2018 https://www.mscharhag.com/java/java-8-string-join
                result += ", ";
            } else {
                result += ")";
            }
        }
        return result;
    }

    /**
     * Метод, который заносит в запрос на создание элемента значение полей элемента
     * (Заполняет VALUES в запросе)
     */
    public static <T> String getColumnValuesInQuery(T t) throws IllegalAccessException {
        Class clazz = t.getClass();
        String result = " VALUES(";
        int counter = clazz.getDeclaredFields().length;
        for (Field field : clazz.getDeclaredFields()) {
            counter--;
            result += getFieldValue(field, t);
            if (counter != 0) {
                result += ", ";
            } else {
                result += ")";
            }
        }
        return result;
    }






    /**-----------------------------------------------Update----------------------------------------------*/

    /**
     * Метод, для создания универсального sql запроса для метода update()
     */
    public static <T> String getSqlQueryForUpdate(T t) throws IllegalAccessException {
        String sql = "UPDATE " + getTableName(t) + " SET ";
        int counter = t.getClass().getDeclaredFields().length;
        for (Field field : t.getClass().getDeclaredFields()) {
            counter--;
            String columnName = getColumnNameFromAnnotation(field);
            Object columnValue = getFieldValue(field, t);
            sql += columnName + " = " + columnValue;
            if (counter != 0) {
                sql += ", ";
            } else {
                sql += " WHERE ";
            }
        }
        Field primaryId = getPrimaryIdField(t);
        sql += primaryId.getName() + " = " + getFieldValue(primaryId, t);
        return sql;
    }






    /**-----------------------------------------Delete--------------------------------------*/

    /**
     * Метод, для создания универсального sql запроса для метода delete()
     */
    public static <T, I> String getSqlQueryForDelete(I id, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        String sql = "DELETE FROM " + getTableName(t)
                + "WHERE " + getPrimaryIdField(t).getName()
                + " = " + id;

        String.format(DELETE_QUERY_TEMPLATE, getTableName(t), getPrimaryIdField(t).getName(), id);
        return sql;
    }






    /**-------------------------------------------Get--------------------------------------*/

    /**
     * Метод, для создания универсального sql запроса для метода get()
     */
    public static <T, I> String getSqlQueryForGet(I id, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        String sql = "SELECT * FROM " + getTableName(t)
                + " WHERE " + getPrimaryIdField(t).getName()
                + " = " + id;
        return sql;
    }






    /**----------------------------------------------Others-----------------------------------*/

    /**
     * Метод, который заносит значение поля строчного типа в кавычки, а значение всех остальных типов
     * просто преобразовывает в строку
     */
    public static <T> Object getFieldValue(Field field, T t) throws IllegalAccessException {
        field.setAccessible(true);
        Object value = field.get(t);
        if (field.getType().equals(String.class)) {
            value = "'" + value + "'";
        }
        return value;
    }


    /**
     * Метод, для получения из ResultSet значения для поля field
     */
    public static Object getColumnValue(Field field, ResultSet resultSet) throws SQLException {
        field.setAccessible(true);
        String columnName = getColumnNameFromAnnotation(field);
        return resultSet.getObject(columnName);
    }


    /**
     * Метод, который возвращает имя таблицы
     */
    public static <T> String getTableName(T t) {
        String result = "";
        if (t.getClass().isAnnotationPresent(Entity.class)) {
            Annotation annotation = t.getClass().getAnnotation(Table.class);
            String tableName = ((Table) annotation).name(); // TODO: 10.12.2018 if @Table not specified name?
            result += tableName + " ";
        } else {
            return null;
        }
        return result;
    }


    /**
     * Метод, для получения из аннотации Column имени поля(колонки в таблице)
     * Если анотации нет то возвращаеться имя поля.
     */
    public static String getColumnNameFromAnnotation(Field field) {
        field.setAccessible(true);
        String columnName;
        if (field.isAnnotationPresent(Column.class)) {
            Annotation columnAnnotation = field.getAnnotation(Column.class);
            columnName = ((Column) columnAnnotation).name();
        } else {
            columnName = field.getName();
        }
        return columnName;
    }


    /**
     * Метод, который получает primary id из класа или его родителя AbstractEntity
     */
    public static <T> Field getPrimaryIdField(T t) {
        List<Field> fields = new ArrayList<>();
        addArrayToList(fields, t.getClass().getDeclaredFields());
        addArrayToList(fields, t.getClass().getSuperclass().getDeclaredFields());
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryId.class)) {
                return field;
            }
        }
        return null;
    }


    /**
     * Метод для добавление элементов масива в список
     */
    public static <E> void addArrayToList(List<E> list, E[] array) {
        for (E e : array) {
            list.add(e);
        }
    }


    /**
     * Метод, который выводит элементы списка с счетчиком
     */
    public static <E> void outputList(List<E> list) {
        int counter = 1;
        for (E e : list) {
            System.out.println(counter++ + ")" + e);
        }
    }
}
