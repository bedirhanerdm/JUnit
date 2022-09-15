package day_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterClass {


    // Before Class ve After Class, islemleri ayni sayfa uzerinde yapar


    static WebDriver driver;

    // before class icin olusturacagimiz class static olmalidir
    @BeforeClass
    public static void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public static void tearDown(){

        driver.close();

    }


    @Test
    public void method1() throws InterruptedException {


        driver.get("https://amazon.com");
        Thread.sleep(1000);

    }



    @Test
    @Ignore // calismasini istemedigimiz method icin ignore kullanilir
    public void method2() throws InterruptedException {

        driver.get("https://hepsiburada.com");
        Thread.sleep(1000);

    }



    @Test
    public void method3() throws InterruptedException {

        driver.get("https://techproeducation.com");
        Thread.sleep(1000);

    }


}
