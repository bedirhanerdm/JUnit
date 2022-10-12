package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Iframe {


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
    public void test1(){   // https://html.com/tags/iframe/ adresine gidiniz
                           // sitedeki youtube videosunu calistirin

            driver.get("https://html.com/tags/iframe/");

            WebElement ytFrame = driver.findElement(By.xpath("//*[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
            driver.switchTo().frame(ytFrame);
            ytFrame.click();

        }
}
