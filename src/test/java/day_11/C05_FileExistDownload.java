package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistDownload extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {

        //  https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //  test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[@href=\"download/test.txt\"]")).click();

        //  Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        Thread.sleep(2000);

        String dosya = "C:\\Users\\bedir\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosya)));
    }
}
