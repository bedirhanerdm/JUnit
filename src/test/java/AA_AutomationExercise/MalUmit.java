package AA_AutomationExercise;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;

public class MalUmit {

    static WebDriver driver;
    static Actions actions;
    static Select select;
    static Faker faker;


    @BeforeClass

    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        faker = new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){

        //driver.close();

    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("https://amazon.com.tr");

        driver.findElement(By.id("sp-cc-accept")).click();



        WebElement categories = driver.findElement(By.id("searchDropdownBox"));

        select = new Select(categories);

        select.selectByIndex(12);

        Thread.sleep(1000);

        actions.sendKeys("umitin poposu", Keys.ENTER).perform();

    }


    @Test
    public void test2() throws InterruptedException {

        driver.findElement(By.xpath("(//*[@class=\"s-image\"])[3]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-micro\"]")).getText().contains("148"));

        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(1000);


        driver.findElement(By.xpath("//*[@name=\"proceedToRetailCheckout\"]")).click();

        driver.findElement(By.id("createAccountSubmit")).click();

        Thread.sleep(1000);

        String password = faker.internet().password();


        driver.findElement(By.id("ap_customer_name"));

        actions.sendKeys(faker.name().firstName() + " " + faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(password).
                sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();







    }
}
