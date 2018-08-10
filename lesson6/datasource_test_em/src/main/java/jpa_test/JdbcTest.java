package jpa_test;


import jpa_test.models.Company;
import jpa_test.models.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {


        List objectsFromDB = getListOfObjects(User.class);
        System.out.println(objectsFromDB);

    }

    private static List getListOfObjects(Class objClass) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Annotation dbTable = objClass.getAnnotation(DBTable.class);
        List objectsFromDB = new ArrayList();
        if (dbTable != null) {
            String tableName = ((DBTable) dbTable).name();
            List<ORMModel> ormModelList = getOrmModels(objClass);
            String sql = getSqlAsString(tableName, ormModelList);
            objectsFromDB = getResultFromDB(objClass, ormModelList, sql);

        }
        return objectsFromDB;
    }

    private static List getResultFromDB(Class objClass, List<ORMModel> ormModelList, String sql) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List objectsFromDB = new ArrayList();//GOAL -> objects from db, not string values

        while (resultSet.next()) {
            Object newInstance = getObjectFromDB(objClass, ormModelList, resultSet);
            objectsFromDB.add(newInstance);
        }
        connection.close();
        return objectsFromDB;
    }

    private static Object getObjectFromDB(Class objClass, List<ORMModel> ormModelList, ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, ClassNotFoundException {
        Object newInstance = objClass.newInstance();//User was created by default constructor

        for (ORMModel ormModel : ormModelList) {
            getFieldFromDB(resultSet, newInstance, ormModel);
//                    System.out.println(columnValue);
        }
        return newInstance;
    }

    private static void getFieldFromDB(ResultSet resultSet, Object newInstance, ORMModel ormModel) throws SQLException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Object columnValue = null;
        Field declaredField = newInstance.getClass().getDeclaredField(ormModel.getFieldName());
        Class fieldType = declaredField.getType();
        DBFK fkAnnotation = declaredField.getAnnotation(DBFK.class);
        if (fkAnnotation == null) {
            columnValue = resultSet.getObject(ormModel.getColumnName(), fieldType);
        } else {
            Integer foreignObjectId = resultSet.getInt(ormModel.getColumnName());
            DBTable tableAnnotation = (DBTable) fieldType.getAnnotation(DBTable.class);
            if (tableAnnotation != null) {
                String tableName = tableAnnotation.name();
                List<ORMModel> ormModels = getOrmModels(fieldType);
                String sqlAsString = getSqlAsString(tableName, ormModels, foreignObjectId);
                List resultFromDB = getResultFromDB(fieldType, ormModels, sqlAsString);
                if (resultFromDB.size() == 1) {
                    columnValue = resultFromDB.get(0);
                }
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(newInstance, columnValue);
    }

    private static String getSqlAsString(String tableName, List<ORMModel> ormModelList, Integer id) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (ORMModel ormModel : ormModelList) {
            stringJoiner.add(ormModel.getColumnName());
        }
        //stringJoiner -> id, name
        System.out.println(stringJoiner);

        return String.format("select %s FROM %s WHERE id = %d", stringJoiner, tableName, id);
    }

    private static String getSqlAsString(String tableName, List<ORMModel> ormModelList) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (ORMModel ormModel : ormModelList) {
            stringJoiner.add(ormModel.getColumnName());
        }
        //stringJoiner -> id, name
        System.out.println(stringJoiner);

        return String.format("select %s FROM %s", stringJoiner, tableName);
    }

    private static List<ORMModel> getOrmModels(Class objClass) {
        List<ORMModel> ormModelList = new ArrayList();

        Field[] declaredFields = objClass.getDeclaredFields();
        for (Field field : declaredFields) {
            DBColumn fieldAnnotation = field.getAnnotation(DBColumn.class);
            if (fieldAnnotation != null) {
                System.out.println(" field with name " + field.getName() + " >>> " + fieldAnnotation.name());
                ORMModel ormModel = new ORMModel(fieldAnnotation.name(), field.getName());
                ormModelList.add(ormModel);
            }
        }
        System.out.println(ormModelList);
        return ormModelList;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        //JDBC API
        Class.forName("org.h2.Driver");
        return DriverManager.
                getConnection("jdbc:h2:file:C:/Users/sereg/Desktop/Hillel/java-ee/homework/lesson6/datasource_test_em/test_db", "sa", "sa");
    }
}


class ORMModel {
    private String columnName;//table-plain-data
    private String fieldName;//java-model

    public ORMModel(String columnName, String fieldName) {
        this.columnName = columnName;
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "ORMModel{" +
                "columnName='" + columnName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}