package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {

    // конфигурация для JDBC:
    public static void myDbConnection() throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
        String username = "root";
        String password = "190685";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.createStatement();
            System.out.println("Connection to DB successfully!");

        } catch (Exception e) {
            System.out.println("Connection to DB failed");
            e.printStackTrace();
        }
    }


    // конфигурация для Hibernate:
    private static SessionFactory concreteSessionFactory;

    static {
        try {

            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.driver",
                    "com.mysql.cj.jdbc.Driver");
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "190685");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("show_sql", "true");
            prop.setProperty("CURRENT_SESSION_CONTEXT_CLASS", "thread");
            prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");

            concreteSessionFactory = new org.hibernate.cfg.Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();

            System.out.println("DB mydb подключена!");


        } catch (HibernateException e) {
            System.out.println("DB mydb НЕ подключена!");
            e.printStackTrace();
        }
    }

    public static Session myDbConnectionHibernate() throws HibernateException {
        return concreteSessionFactory.openSession();
    }
}
