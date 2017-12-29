package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

public class StoredPostTestSuite {

    @Test
    public void Should_UpdateVipLevels() throws Exception {
        //Given&When&Then
        int howMany = updateTester(
                "READERS",
                "VIP_LEVEL",
                "UpdateVipLevels");

        Assert.assertEquals(0, howMany);
    }

    @Test
    public void Should_UpdateBestsellers() throws Exception {
        //Given&When&Then
        int howMany = updateTester(
                "BOOKS",
                "BESTSELLER",
                "UpdateBestsellers");

        Assert.assertEquals(0, howMany);
    }

    private int updateTester(String testedTable, String testedColumn, String updateProcedure) throws Exception {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE " + testedTable + " SET " + testedColumn + "=NULL";
        Statement statement = dbManager.getConnection()
                .createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL " + updateProcedure + "()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM " + testedTable + " WHERE " + testedColumn + "=NULL";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }

        return howMany;
    }
}
