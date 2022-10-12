package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class C02_Actions extends TestBaseBeforeAfter {

    @Test
    public void name() {

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");


        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();


        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[1]"));
        isim.sendKeys("lionel");

        actions.sendKeys(Keys.TAB).sendKeys("Mesi").
                sendKeys(Keys.TAB).sendKeys("alalalala@gmail.com").
                sendKeys(Keys.TAB).sendKeys("alalalala@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Zbolobloblob22!!").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("25").
                sendKeys(Keys.TAB).sendKeys("jan").
                sendKeys(Keys.TAB).sendKeys("2001").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }
}
