package AA_AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A02 {


    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){

        //driver.close();

    }


    @Test
    public void test(){

       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//*[@style=\"color: orange;\"]")).click();

       // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

       // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();

       // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());

       // 6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("bedirhanerdm@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("abcdfghijkl");

       // 7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();

       // 8. Verify that 'Logged in as username' is visible
       // 9. Click 'Delete Account' button
       // 10. Verify that 'ACCOUNT DELETED!' is visible

    }















}
