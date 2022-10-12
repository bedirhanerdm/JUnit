package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
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

public class C02_DropDown {

    WebDriver driver;
    Select select;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com/");

    }

    @After
    public void tearDown(){
        //driver.close();
    }


    @Test
    public void test1(){

        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(ddm);  // Class levelde aciyorum

        /*

        Dropdown menu ye ulasmak icin Select classindan obje olusturup,
        bu objenin getOptions() methodu ile locate ettigimiz yerdeki tum elementleri
        bir list icine atabiliriz. List in size ini yazdirarak da tum option sayisini bulabiliriz

         */

        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());


    }

    @Test
    public void test2(){

        // -Test2
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(ddm);

        select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");



    }

}
