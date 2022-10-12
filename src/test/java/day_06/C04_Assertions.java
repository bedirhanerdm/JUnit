package day_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {


    /*





     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // * https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }



    // * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin


    @AfterClass
    public static void tearDown(){

        // driver.close();
    }



    @Test
    public void test1(){

        // * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));


    }



    @Test
    public void test2(){

        // * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"logo-icon\"]")).isDisplayed());


    }



    @Test
    public void test3(){

        // * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search\"]")).isEnabled());

    }



    @Test
    public void test4(){

        // * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().contains("youtube"));


    }


}
