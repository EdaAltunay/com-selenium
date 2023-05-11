package exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C06 extends TestBase {
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 4 olduğunu test edin



    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement dropdownMenuElementi=driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        Select select=new Select(dropdownMenuElementi);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        System.out.println("**************");
        //	4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionsList=select.getOptions();
        for (WebElement eachElement: optionsList) {
            System.out.println(eachElement.getText());

        }



        //	5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedsize=4;
        int actualsize=optionsList.size();
        Assert.assertEquals(expectedsize,actualsize);









    }
}
