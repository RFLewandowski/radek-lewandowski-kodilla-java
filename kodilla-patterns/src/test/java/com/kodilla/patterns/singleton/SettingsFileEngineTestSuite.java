package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsFileEngineTestSuite {
    //private static SettingsFileEngine settingsFileEngine;

    @BeforeClass
    public static void openSettingsFile() {
        SettingsFileEngine
                .getInstance()
                .open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        SettingsFileEngine
                .getInstance()
                .close();
    }

    @Test
    public void Should_GetFileName() {
        //Given
        //When
        String fileName = SettingsFileEngine
                .getInstance()
                .getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        Assert.assertEquals("myapp.settings", fileName);
    }

    @Test
    public void Should_LoadSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine
                .getInstance()
                .loadSettings();
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void Should_SaveSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine
                .getInstance()
                .saveSettings();
        //Then
        Assert.assertTrue(result);
    }
}
