package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");


        // 2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));


        // 3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);


        // 4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucSayisi = driver.findElements(By.className("sg-col-inner"));

        System.out.println(sonucSayisi.get(0).getText()); // 1-16 of 250 results for "Samsung headphones"


        String sonuc = sonucSayisi.get(0).getText();

        String[] sonuc1 = sonuc.split(" ");

        System.out.println(sonuc1[2] + " " + sonuc1[3]);



        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='s-image']")).click();


        // 6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.getTitle());




        Thread.sleep(2000);
        driver.close();
    }
}
