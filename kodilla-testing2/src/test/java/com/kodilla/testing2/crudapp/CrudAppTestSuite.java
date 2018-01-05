package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://rflewandowski.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void setUp() throws Exception {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void Should_CreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteCrudAppTestTask(taskName);
    }


    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        WebDriver removalDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        removalDriver.get(BASE_URL);

        removalDriver.navigate().refresh();

        while (!removalDriver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        removalDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDelete = theForm
                            .findElement(By.xpath(".//button[@class='datatable__button'][2]"));
                    buttonDelete.click();
                });
        Thread.sleep(2000);
        removalDriver.close();
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("dummyUser");
        driverTrello.findElement(By.id("password")).sendKeys("dummyPassword");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]"))
                .stream()
                .filter(aHref -> aHref
                        .findElements(By.xpath(".//span[@title=\"Kodilla Application\"]"))
                        .size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span"))
                .stream()
                .filter(theSpan -> theSpan
                        .getText()
                        .contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private void sendTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreated = theForm
                            .findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreated.click();
                });
        Thread.sleep(5000);
    }


    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//fieldset[@class='datatable__row-section datatable__row-section--input-section']/input";
        final String XPATH_TASK_CONTENT = "//fieldset[@class='datatable__row-section datatable__row-section--input-section']/textarea";
        final String XPATH_ADD_BUTTON = "//form[@class='datatable__row datatable__row--add']/fieldset[@class='datatable__row-section datatable__row-section--button-section']/button[@class='datatable__button']";

        String taskName = "Task number " + generator.nextInt();
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement button = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        button.click();
        Thread.sleep(2000);
        return taskName;
    }
}
