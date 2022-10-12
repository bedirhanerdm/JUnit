package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Odev {



    Select select;
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.navigate().to("http://zero.webappsecurity.com/");

    }

    @AfterClass
    public static void tearDown(){

        // driver.close();
    }


    @Test
    public void test1(){    // 2. Sign in butonuna basin

        driver.findElement(By.id("signin_button")).click();

    }


    @Test
    public void test2() throws InterruptedException {   // 3. Login kutusuna “username” yazin
                                                        // 4. Password kutusuna “password.” yazin
                                                        // 5. Sign in tusuna basin
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        Thread.sleep(1000);


    }

    @Test
    public void test3(){

        driver.navigate().back();

    }


    @Test
    public void test4() throws InterruptedException {   // 6. Pay Bills sayfasina gidin
                                                        // 7. “Purchase Foreign Currency” tusuna basin
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

    }


    @Test
    public void test5() throws InterruptedException {   // 8. “Currency” drop down menusunden Eurozone’u secin
                                                        // 9. “amount” kutusuna bir sayi girin
                                                        // 10. “US Dollars” in secilmedigini test edin

        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        select = new Select(dropDown);

        select.selectByVisibleText("Eurozone (euro)");

        Thread.sleep(1000);

        driver.findElement(By.id("pc_amount")).sendKeys("250");

        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.id("pc_inDollars_true")).isSelected());

    }



    @Test
    public void test6() throws InterruptedException {   // 11. “Selected currency” butonunu secin
                                                        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_inDollars_false")).click();
        driver.findElement(By.id("pc_calculate_costs")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("purchase_cash")).click();

    }


    @Test
    public void test7(){    // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        Assert.assertTrue(driver.findElement(By.id("alert_content")).getText().contains("Foreign currency cash was successfully purchased"));



    }





}
