package applications;

import databaseconnection.JDBCDatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Exercise2 {
    static Connection connection = null;
    static Statement statement = null;
    static Properties properties = new Properties();

    private static final String SELECT_QUERY_EMP_SALARY="select * from employeesalary";
    private static final String SELECT_QUERY_EMP_DEMOGRAPHICS="select * from employeedemographics";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        List<EmployeeSalary> employeeSalaryList = new ArrayList<>();
        List<EmployeeDemographics> employeeDemographicsList = new ArrayList<>();
        properties.load(Exercise2.class.getClassLoader().getResourceAsStream("config.properties"));

        connection = JDBCDatabaseConnection.getConnection(
                properties.getProperty("db_url"),
                properties.getProperty("db_user"),
                properties.getProperty("db_pwd"));


        statement = connection.createStatement();

        ResultSet resultSetEmpSal = statement.executeQuery(SELECT_QUERY_EMP_SALARY);
        while (resultSetEmpSal.next()){
            EmployeeSalary employeeSalary = new EmployeeSalary();
            employeeSalary.setEmplId(resultSetEmpSal.getInt(1));
            employeeSalary.setJobTitle(resultSetEmpSal.getString(2));
            employeeSalary.setSalary(resultSetEmpSal.getInt(3));
            employeeSalaryList.add(employeeSalary);
        }
        System.out.println("DETAILS OF THE EMPLOYEE SALARY");
        for (EmployeeSalary empSal : employeeSalaryList)
            System.out.println(empSal);


        ResultSet resultSetEmpDemo = statement.executeQuery(SELECT_QUERY_EMP_DEMOGRAPHICS);
        while (resultSetEmpDemo.next()){
            EmployeeDemographics employeeDemographics = new EmployeeDemographics();
            employeeDemographics.setEmpId(resultSetEmpDemo.getInt(1));
            employeeDemographics.setFirstName(resultSetEmpDemo.getString(2));
            employeeDemographics.setLastName(resultSetEmpDemo.getString(3));
            employeeDemographics.setAge(resultSetEmpDemo.getInt(4));
            employeeDemographics.setGender(resultSetEmpDemo.getString(5));
            employeeDemographicsList.add(employeeDemographics);
        }
        System.out.println("DETAILS OF THE EMPLOYEE DEMOGRAPHICS");
        for (EmployeeDemographics empDemo : employeeDemographicsList)
            System.out.println(empDemo);

        if(statement!=null)
            statement.close();

        if(connection!=null)
            connection.close();

    }

}
