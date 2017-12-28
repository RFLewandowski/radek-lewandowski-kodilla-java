package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

public class StoredPostTestSuite {

    @Test
    public void Should_UpdateVipLevels() throws Exception {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"NOT SET\"";
        Statement statement = dbManager.getConnection()
                .createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"NOT SET\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(rs.next()){
            howMany=rs.getInt("HOW_MANY");
        }
        Assert.assertEquals(0,howMany);
    }
}
