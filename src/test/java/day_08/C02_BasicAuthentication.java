package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BasicAuthentication {


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }


    @AfterClass
    public static void tearDown(){
        //driver.close();
    }



    @Test
    public void test1() throws InterruptedException {  // https://the-internet.herokuapp.com/basic_auth sitesine gidin
                                                       // asagidaki yontem ve test datalarini kullanarak authentication'i yapin
                                                       // -Html komutu :https://username:password@URL
                                                       // -Username:admin
                                                       // -password:admin
                                                       //  Basarili sekilde sayfaya girildigini dogrulayin


        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(1000);

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='\n" +
                "    Congratulations! You must have the proper credentials.\n" +
                "  ']")).isDisplayed());


    }
}
