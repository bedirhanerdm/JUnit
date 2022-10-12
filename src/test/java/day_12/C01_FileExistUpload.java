package day_12;

import Utilities.TestBaseBeforeAfter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C01_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        // chooseFile butonuna basalim
        // Yuklemek istediginiz dosyayi secelim.
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\bedir\\Downloads\\Selenium batch81 (2).pdf");

        /*
        Dosya sec e basinca windows sekmesi acacagi ve mudahale edemeyecegimiz icin dosya sec butonu uzerine
        dosya yolunu yaziyoruz
         */

        // Upload butonuna basalim
        driver.findElement(By.id("file-submit")).click();


        // “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
