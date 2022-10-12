package day_11;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Faker extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        // 1-"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");


        // 2-"create new account"  butonuna basin
        driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();


        // 3- Butun gereken bilgileri girin ve kaydol butonuna basin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[1]"));
        String email = faker.internet().emailAddress();

        /*
        Faker randomize kullanabilmek icin mvnrepository den java faker kutuphanesini alip pom.xml dosyaya ekledik
         */

        actions.click(isim).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("25").
                sendKeys(Keys.TAB).sendKeys("jan").
                sendKeys(Keys.TAB).sendKeys("2001").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }
}
