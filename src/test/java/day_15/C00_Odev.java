package day_15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C00_Odev {


    @Test
    public void test1() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());


        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String t1 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(t1);


        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        Assert.assertEquals(workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString(), "Kabil");



        //Satir sayisini bulalim
        System.out.println(workbook.getSheetAt(0).getLastRowNum());


        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheetAt(0).getPhysicalNumberOfRows());


        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    }


}
