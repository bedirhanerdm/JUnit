package day_14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {

        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";


        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //olusturmus oldugumuz dosya yolunu sistemde isleme alir


        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);  //Workbook objesiyle akisa aldigimiz dosyamizla bir excell dosyasi olusturduk


        // Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");


        // Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);  // 4. blok, index 0dan baslar


        // Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // 4. blok
        System.out.println(cell);

        // 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expData = "Cezayir";
        String actData = cell.toString();

        Assert.assertEquals(expData, actData);


    }
}
