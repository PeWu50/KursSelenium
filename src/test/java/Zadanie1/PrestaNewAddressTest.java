package Zadanie1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrestaNewAddressTest {
    private WebDriver driver;
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }
    @After
    public void tearDown() {
    driver.quit();
    }
    @Test
    public void loginwithProperCredentials() {

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pewe@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("pe19we69");

        driver.findElement(By.id("submit-login")).click();
        //kliknij w przycisk adres
        driver.findElement(By.id("addresses-link")).click();

        WebElement createnewaddressesButton = this.driver.findElement(By.cssSelector("[data-link-action='add-address']"));
        createnewaddressesButton.click();

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys("Dluga 1");

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys("Krakow");

        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys("33-333");

        WebElement saveButton = driver.findElement(By.cssSelector("[class='btn btn-primary float-xs-right']"));
        saveButton.click();

        Assert.assertEquals("Address successfully added!",
                driver.findElement(By.cssSelector("[class='alert alert-success']")).getText());

        List<WebElement> userAddresses = driver.findElements(By.cssSelector("[class='address-body']"));
        String lastElement = userAddresses.get(userAddresses.size() - 1).getText();
        if (lastElement.isEmpty()) {
            Assert.fail();
        }
        else {
            Assert.assertTrue(lastElement.contains("Pe We"));
            Assert.assertTrue(lastElement.contains("Dluga 1"));
            Assert.assertTrue(lastElement.contains("Krakow"));
            Assert.assertTrue(lastElement.contains("33-333"));
            Assert.assertTrue(lastElement.contains("United Kingdom"));
            System.out.println("Correct");
        }
    }
}
