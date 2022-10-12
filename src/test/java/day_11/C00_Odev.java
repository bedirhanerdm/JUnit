package day_11;


import Utilities.TestBaseBeforeAfter;
import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class C00_Odev extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin ve Hover over Me First" kutusunun ustune gelin
        // 2- Link 1" e tiklayin

        driver.get("http://webdriveruniversity.com/Actions");

        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).
                click(driver.findElement(By.xpath("(//*[@href=\"#\"])[1]"))).perform();

        Thread.sleep(1000);



        // 3- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());


        // 4- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        // 5- "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.id("click-box"))).perform();


        // 6- "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());



        // 7- "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.id("double-click"))).perform();

        Thread.sleep(1000);

        driver.close();
    }


}
