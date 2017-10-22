package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    private ResultSet rs = null;
    private Statement statement = null;

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT * FROM USERS";
        ResultSet rs = queryDB(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }


    @Test
    public void Should_ShowUsers_When_HaveMoreThanTwoPosts() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM POSTS P, USERS U\n" +
                "WHERE P.USER_ID = U.ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2;";
        ResultSet rs = queryDB(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(
                    rs.getString("FIRSTNAME") + ", " +
                            rs.getString("LASTNAME") + ", " +
                            rs.getInt("POSTS_NUMBER"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(1, counter);
    }


    private ResultSet queryDB(String sqlQuery) throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        statement = dbManager
                .getConnection()
                .createStatement();
        rs = statement.executeQuery(sqlQuery);
        return rs;
    }
}