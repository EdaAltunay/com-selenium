package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){
        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //  /Users/ahmetbulutluoz/Downloads/foto.png
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"


        System.out.println(System.getProperty("user.dir"));
        //C:\Users\MONSTER\IdeaProjects\com.Team113_JUnit
        // Projenin dosya yolunun herkesde FARKLI olan kismi.

        System.out.println(System.getProperty("user.home"));
        // C:\Users\MONSTER
        // indirdigimiz dosyanin dosya yolunun hepimizde FARKLI olan kismi.
        // bilgisayarimizda bulunan user klasorunu verir.


        /* biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            C:\Users\MONSTER                     /Downloads/a.png
            herkesin bilgisayarinda farkli       herkeste ayni
            System.getProperty("user.home")      /Downloads/a.png
         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/a.png";

        String dosyaYolu= dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // *******************************************************************************
        // ayni islemi projemizin altindaki "deneme.txt" icin yapsak.Gene ikiye boluyoruz


        // deneme.txt den kopyaladigimiz dosya yolu : dosya yolumuzun ikinci kismini olusturuyor.
        // hepimizde ayni olan kisim
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt
        dosyaYoluherkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        // C:\Users\MONSTER\IdeaProjects\com.Team113_JUnit

        dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;

        System.out.println("dosya yolu : "+dosyaYolu);
        // C:\Users\MONSTER\IdeaProjects\com.Team113_JUnit/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }


}
