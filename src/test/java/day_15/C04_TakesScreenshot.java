package day_15;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_TakesScreenshot extends TestBaseBeforeAfter {


    @Test
    public void test1() throws IOException {

        // amazona gidelim ve tum sayfa screenshot alalim
        driver.get("https://amazon.com");


        // Casting yapiyoruz
        TakesScreenshot ss = (TakesScreenshot) driver;


        // Ekran goruntusunu gecici bir yere atalim
        File pageSS = ss.getScreenshotAs(OutputType.FILE);

        // Onceki dosyayi bir yere kaydedelim
        FileUtils.copyFile(pageSS, new File("target/ekranGoruntusu/allPage" + tarih + ".jpeg"));

    }
}
