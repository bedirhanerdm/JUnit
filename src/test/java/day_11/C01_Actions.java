package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");


        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("sung").
                sendKeys(" ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").
                sendKeys("1").
                sendKeys(Keys.ENTER).
                perform();



        // Aramanin gerceklestigini test edin
        Assert.assertTrue(driver.getTitle().contains("samsung A71"));

    }
}
