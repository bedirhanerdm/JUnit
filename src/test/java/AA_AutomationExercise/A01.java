package AA_AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A01 {



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
        driver.close();
    }


    @Test
    public void test1() throws InterruptedException {

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully


        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();


        // 5. Verify 'New User Signup!' is visible
        WebElement signUpWE = driver.findElement(By.xpath("(//*[@class='col-sm-4'])[1]"));

        if (signUpWE.isDisplayed()){
            System.out.println("New User Signup Test PASSED");
        }else System.out.println("New User Signup Test FAILED");



        // 6. Enter name and email address
        WebElement nameBox = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        WebElement emailBox = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));

        nameBox.sendKeys("Bedirhan Erdem");
        emailBox.sendKeys("yusuaaafi@gmail.com");


        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();




        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accInfo = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));

        if (accInfo.isDisplayed()){
            System.out.println("Enter Acc information Test PASSED");

        }else System.out.println("Enter Acc information Test FAILED");


        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("abcdefghijkl");

        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1997");




        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.name("newsletter")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.name("optin")).click();





        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Ahmet");
        driver.findElement(By.id("last_name")).sendKeys("Erdem");

        driver.findElement(By.id("company")).sendKeys("Amazon");

        driver.findElement(By.id("address1")).sendKeys("Atakum/Samsun");
        driver.findElement(By.id("address2")).sendKeys("Atakum/Samsun");

        Thread.sleep(1000);


        driver.findElement(By.id("country")).sendKeys("U");

        driver.findElement(By.id("state")).sendKeys("Karadeniz");
        driver.findElement(By.id("city")).sendKeys("Samsun");
        driver.findElement(By.id("zipcode")).sendKeys("55200");




        driver.findElement(By.id("mobile_number")).sendKeys("5300000000");





        //13. Click 'Create Account button
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();


        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement AccCreate = driver.findElement(By.xpath("//*[text()='Account Created!']"));

        if (AccCreate.isDisplayed()){
            System.out.println("Acc Create Test PASSED");
        }else System.out.println("Acc Create Test FAILED");


        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();


        // 16. Verify that 'Logged in as username' is visible
        WebElement loggedIn = driver.findElement(By.xpath("//*[text()='Bedirhan Erdem']"));

        if (loggedIn.isDisplayed()){
            System.out.println("log in test PASSED");
        }else System.out.println("log in test FAILED");


        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();


        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button










    }











}
