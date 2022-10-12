package AA_AutomationExercise;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InstaBot extends TestBaseBeforeAfter {

    @Test
    public void name() throws InterruptedException {

        driver.get("https://twitter.com/?logout=1664110482485");

        Faker faker = new Faker();

        driver.findElement(By.xpath("(//*[@role=\"link\"])[1]")).click();

        driver.findElement(By.xpath("//*[text()='Use email instead']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@class=\"css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv\"])[1]")).click();

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();


        actions.sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Marc").sendKeys(Keys.TAB).sendKeys("14").sendKeys(Keys.TAB).sendKeys("1995").sendKeys(Keys.TAB).
                perform();

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@role=\"button\"])[3]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@role=\"button\"])[2]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@role=\"button\"])[4]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"home_children_button\"]")).click();




    }
}
