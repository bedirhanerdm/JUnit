package day_11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist {

    @Test
    public void test1() {

        String dosyaYolu = "C:\\Project\\a.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Web sitesinden indirdigimiz dosyanin indigini ya da orda oldugunu test ederiz
    }
}
