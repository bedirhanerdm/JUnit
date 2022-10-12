package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C00_Odev2 extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // https://html.com/tags/iframe/ sayfasina gidelim  3. video’yu gorecek kadar asagi inin
        driver.get("https://html.com/tags/iframe/");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // videoyu izlemek icin Play tusuna basin
        WebElement video = driver.findElement(By.xpath("(//*[@class=\"render\"])[1]"));
        driver.switchTo().frame(video);

        actions.moveToElement(video).click();

        // videoyu calistirdiginizi test edin

    }




}
