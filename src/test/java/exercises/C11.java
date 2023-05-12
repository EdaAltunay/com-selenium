package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C11 extends TestBase {

    @Test
    public void test() {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // title'in Amazon kelimesi icerdigini test edin
        String expected = "Amazon";
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected));

        String amazonWHD = driver.getWindowHandle();
        // yeni bir tab acarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String wiseWHD = driver.getWindowHandle();

        // url'in wisequarter icerdigini test edin
        expected = "wisequarter";
        actual=driver.getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        // tekrar amazon'un acik oldugu sayfaya gecin
        driver.switchTo().window(amazonWHD);
        // ve url'in amazon icerdigini test edin
        expected="amazon";
        actual=driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

    }

}
