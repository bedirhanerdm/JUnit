package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcel1() throws IOException {

        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";


        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //olusturmus oldugumuz dosya yolunu sistemde isleme alir


        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);  //Workbook objesiyle akisa aldigimiz dosyamizla bir excell dosyasi olusturduk

        // Sheet, Cell ve row belirleyip yazdiralim
        String actualData = workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();

        System.out.println(actualData);
    }
}
