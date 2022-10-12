package day_15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test1() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        // 5.Hucreye yeni bir cell olustur ve Nufus yaz
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");


        // 2. satir nufus kolonuna 1500000 yazdir
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");


        // 10. satir nufus kolonuna 250000 yazdir
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");


        // 15. satir nufus kolonuna 54000 yazdir
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");


        // Kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        workbook.write(fos);


        // Kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
