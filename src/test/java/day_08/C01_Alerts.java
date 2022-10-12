package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {




    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    @Test
    public void test1() throws InterruptedException {   // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
                           // Click for JS Alert butonuna tıklayalım
                           // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();


    }

    @Test
    public void test2() throws InterruptedException {   // 2. butona tiklayin, ordaki mesaji yazdirin, cancel yapin ve sonuc yazisinda successfuly olmadigini test edin

        driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]")).click();

        System.out.println("Uyaridaki mesaj : " + driver.switchTo().alert().getText());

        Thread.sleep(1000);

        driver.switchTo().alert().dismiss();

        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"));

    }

    @Test
    public void test3() throws InterruptedException {   // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, Alert üzerindeki mesajı yazdırınız,
                                                        // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Bedirhan Erdem");

        System.out.println("Alert uzerindeki mesaj: " + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Bedirhan Erdem"));




    }


}
