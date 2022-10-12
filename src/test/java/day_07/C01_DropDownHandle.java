package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class C01_DropDownHandle {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ●https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown(){
        //driver.close();
    }


    @Test
    public void test1(){

        // -Test1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 olmadigini test edin
        List<WebElement> drops = driver.findElements(By.xpath("//*[@aria-describedby=\"searchDropdownDescription\"]"));
        int dropsTest = 45;
        int dropsList = drops.size();
        Assert.assertNotEquals(dropsList, dropsTest);

    }


    @Test
    public void test2(){

        // -Test2
        // 1.Kategori menusunden Books secenegini secin
        driver.findElement(By.id("searchDropdownBox"))
                .sendKeys("Books");

        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);


        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonucWE = driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
        String sonuc = sonucWE.getText();

        String[] sonucARR = sonuc.split(" ");
        System.out.println(sonucARR[3] + " " + sonucARR[4]);


        // 4.Sonucun Java kelimesini icerdigini test edin
        WebElement sonucYazisi = driver.findElement
                (By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));

        String sonucYazisiStr = sonucYazisi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("Java"));

    }









}
