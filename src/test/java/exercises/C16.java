package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C16 extends TestBase {
    // 2- https://www.amazon.com sayfasina gidelim
    // 3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    // 4- aramanin gerceklestigini test edin.

    @Test
    public void test() throws InterruptedException {

        // 2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusuElement = driver.findElement(By.id("twotabsearchtextbox"));

        // 3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin

        actions.click(aramaKutusuElement)
                .sendKeys("Samsung A71").sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        // 4- aramanin gerceklestigini test edin.
       String expected="Samsung A71";
       String actual=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")).getText();

        Assert.assertTrue(actual.contains(expected));
    }


}
