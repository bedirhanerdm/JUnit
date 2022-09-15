package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_OdevTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1- https://amazon.com/ adresine gidin
        driver.navigate().to("https://amazon.com/");
        Thread.sleep(1000);



        // 2- sayfayi refresh yapin
        driver.navigate().refresh();



        // 3- Sayfa basliginin spend less icerdigini kontrol edin
        String baslik = driver.getTitle();

        if (baslik.contains("Spend less")){

            System.out.println("baslik testi PASSED");
        }else System.out.println("baslik testi FAILED");



        // 4- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@data-csa-c-slot-id='nav_cs_3']")).click();



        // 5- Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();



        // 6- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@aria-label='Best Sellers']")).click();
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();



        // 7- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]")).click();



        // 8- Urun ucretinin 25$ oldugunu test edin
        WebElement fiyatWE = driver.findElement(By.xpath("//*[@id='gc-live-preview-amount']"));
        String fiyat = fiyatWE.getText();

        if (fiyat.contains("$25")){

            System.out.println("Fiyati 25$");
        }else System.out.println("fiyati 25$ degil");



        // 9- Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();









    }
}
