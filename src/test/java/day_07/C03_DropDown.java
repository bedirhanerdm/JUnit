package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {


    Select select;
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

        // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement indexWE = driver.findElement(By.id("dropdown"));
        select = new Select(indexWE);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(1000);

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement valueWE = driver.findElement(By.id("dropdown"));
        select =new Select(valueWE);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement visibleTextWE = driver.findElement(By.id("dropdown"));
        select = new Select(visibleTextWE);

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> drops = select.getOptions();

        for (WebElement each:drops
             ) {
            System.out.println("Option degerleri" + each.getText());
        }



        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        int actualOptionsNumbers = select.getOptions().size();
        int expectedOptionsNumbers = 4;
        if (actualOptionsNumbers == expectedOptionsNumbers) {
            System.out.println("True");
        } else System.out.println("False");


    }



}
