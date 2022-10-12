package day_13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();

        int satir = 3;
        int sutun = 4;


        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutundaki text : " + cell.getText());


        //Price basligindaki tum numaralari yazdirin
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));

        for (WebElement each:priceBasligi
             ) {
            System.out.println("Price basligindaki degerler: " + each.getText());
        }

         /*

         Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
         Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
         Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
         Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
         sutunlara yani hucrelere<td> tag'i ile ulasilir.

         */

    }

    private void login(){

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));

        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }



}
