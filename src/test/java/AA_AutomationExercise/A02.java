package AA_AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
       // 3. Verify that home page is visible successfully
       // 4. Click on 'Signup / Login' button
       // 5. Verify 'Login to your account' is visible
       // 6. Enter correct email address and password
       // 7. Click 'login' button
       // 8. Verify that 'Logged in as username' is visible
       // 9. Click 'Delete Account' button
       // 10. Verify that 'ACCOUNT DELETED!' is visible

    }















}
