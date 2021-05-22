package zadanie2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Sweter {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @After
    public void tearDown() {
    driver.quit(); }

    @Test
    public void loginWithProperCredentials() throws InterruptedException, IOException {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pewe@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("pe19we69");

        driver.findElement(By.id("submit-login")).click();


        //}
        //@Test
        //public void productSelection() {

        WebElement thingInput = driver.findElement(By.name("s"));
        thingInput.click();
        thingInput.clear();
        thingInput.sendKeys("Hummingbird Printed Sweater");

        driver.findElement(By.className("product")).click();

        WebElement sizeSelectElement = driver.findElement(By.id("group_1"));
        //sizeSelectElement.sendKeys("M");
        Select sizeDropDown = new Select(sizeSelectElement);
        String size = "M";
        sizeDropDown.selectByVisibleText(size);





        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.click();
        sleep(1000);
        quantityInput.clear();
        quantityInput.sendKeys("5");

        WebElement addtocartButton = driver.findElement(By.cssSelector("[class='btn btn-primary add-to-cart']"));
        addtocartButton.click();

        WebElement proceedtocheckoutButton = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        proceedtocheckoutButton.click();

        WebElement checkoutproceedButton = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        checkoutproceedButton.click();

        WebElement continueButton = driver.findElement(By.cssSelector("[class='btn btn-primary continue float-xs-right']"));
        continueButton.click();



        WebElement shippingButton = driver.findElement(By.className("col-sm-1"));
        shippingButton.click();

        WebElement continue2Button = driver.findElement(By.cssSelector("[class='continue btn btn-primary float-xs-right']"));
        continue2Button.click();

        WebElement paymentRadio = driver.findElement(By.id("payment-option-1"));
        paymentRadio.click();

        WebElement agreeCheckBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreeCheckBox.click();

        WebElement paymentConfirmationButton = driver.findElement(By.id("payment-confirmation"));
        paymentConfirmationButton.click();


    }
}


