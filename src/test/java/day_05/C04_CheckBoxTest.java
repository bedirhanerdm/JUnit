package day_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {

    // 1. Bir class oluşturun : CheckBoxTest

    // 2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.


    // a. Verilen web sayfasına gidin.

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

        //driver.close();

    }



    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));

        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        Thread.sleep(1000);

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }else System.out.println("CB1 Secili");

        Thread.sleep(1000);

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }else System.out.println("CB2 Secili");

    }






}
