package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_DAY = "//select[@id='day']";
    public static final String XPATH_MONTH = "//select[@id='month']";
    public static final String XPATH_YEAR = "//select[@id='year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectFieldDay = driver.findElement(By.xpath(XPATH_DAY));
        WebElement selectFieldMonth = driver.findElement(By.xpath(XPATH_MONTH));
        WebElement selectFieldYear = driver.findElement(By.xpath(XPATH_YEAR));

        Select selectDay = new Select(selectFieldDay);
        selectDay.selectByIndex(2);
        Select selectMonth = new Select(selectFieldMonth);
        selectMonth.selectByIndex(2);
        Select selectYear = new Select(selectFieldYear);
        selectYear.selectByIndex(2);
    }
}
