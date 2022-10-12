package day_11;

import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C00_Odev3 extends TestBaseBeforeClassAfterClass {


    @Test
    public void test1() {


        // amazona gidin
        driver.get("https://amazon.com");


        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> dropDownList = driver.findElements
                (By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));


        for (WebElement each:dropDownList
             ) {
            System.out.println(each.getText());
        }

        // dropdown menude 40 eleman olmadigini doğrulayın
        WebElement dropDown = driver.findElement
                (By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        select = new Select(dropDown);

        int expectedNum = 40;
        System.out.println(select.getOptions().size());
        Assert.assertNotEquals(select.getOptions().size(),expectedNum);

    }


    @Test
    public void test2() throws InterruptedException {

        // dropdown menuden elektronik bölümü seçin
        WebElement dropDown = driver.findElement
                (By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        select = new Select(dropDown);

        select.selectByVisibleText("Electronics");

        Thread.sleep(1000);

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        WebElement results = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String[] resultText = results.getText().split(" ");

        System.out.println(resultText[2] + " " + resultText[3]);

        Thread.sleep(1000);

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("iphone"));


        // ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='s-image'])[2]")).click();

        Thread.sleep(1000);

        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urunTitle = driver.getTitle();
        String urunFiyat;


    }


    @Test
    public void test3() throws InterruptedException {

        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        // dropdown’dan bebek bölümüne secin
        WebElement dropDown = driver.findElement
                (By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        select = new Select(dropDown);
        select.selectByVisibleText("Baby");


        Thread.sleep(1000);

        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset",Keys.ENTER);
        WebElement results = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String[] resultText = results.getText().split(" ");

        System.out.println(resultText[2] + " " + resultText[3]);


        // sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(driver.getTitle().contains("puset"));


        Thread.sleep(1000);

        // üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class=\"s-image\"])[3]")).click();


        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String ikinciUrunTitle = driver.getTitle();
        String ikinciUrunFiyat = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-none aok-align-center\"]")).getText();

        Thread.sleep(1000);

        driver.findElement(By.id("add-to-cart-button")).click();

    }
}
