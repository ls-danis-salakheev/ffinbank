package org.ffinbank.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @see 'Task2.sql'
 */
public class Task2 {

    private static final String SQL_FILTER = "select c.name, a.acc_number, t.amount\n" +
            "from account as a\n" +
            "join fin_transaction as t ON a.id = t.account_id\n" +
            "join customer as c ON a.customer_id = c.id\n" +
            "where a.acc_number like '45204%'\n" +
            "group by t.amount\n" +
            "having sum(t.amount) > 0";


    //Sql execution example
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postresql.Driver");

        Connection connection = DriverManager.getConnection("url", "login", "pass");

        ResultSet resultSet = connection.prepareStatement(SQL_FILTER)
                .executeQuery();

        /*
         some sql to object mapping by resultSet etc...
         while (resultSet.next()) {
         }
         */
    }
}
