package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

public class C05 extends TestBaseBeforeClass {
    //● https://www.amazon.com/ adresine gidin.
    //      Test 1
    //    	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //      Test 2
    //    	1. Kategori menusunden Books secenegini  secin
    //    	2. Arama kutusuna Java yazin ve aratin
    //    	3. Bulunan sonuc sayisini yazdirin
    //    	4. Sonucun Java kelimesini icerdigini test edin
    @Test
    public void test01() {
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com/");
        WebElement dropDownMenuElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenuElement);
        int expectedOptionSayisi = 45;
        int actualOptionSayisi = select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com/");
        WebElement dropDownMenuElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenuElement);
        //    	1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");

        //    	2. Arama kutusuna Java yazin ve aratin

        WebElement aramaKutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("Java"+ Keys.ENTER);
        //    	3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(sonucSayiElementi.getText());


        //    	4. Sonucun Java kelimesini icerdigini test edin

        String expectedIcerik="Java";
        String actualSonucYazisi=sonucSayiElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }


}
