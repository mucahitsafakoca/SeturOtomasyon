package tr.com.setur.steps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tr.com.setur.driver.DriverWeb;
import tr.com.setur.methods.Methods;

import static tr.com.setur.methods.Methods.jsExecutor;

public class Steps extends DriverWeb {

    Methods methods = new Methods();

    @Test
    public void testScenario() {
        System.out.println("---Otomasyon Testi Basliyor---");
        methods.waitSeconds(4);
        if (methods.isElementVisible(By.xpath("//*[@id='close-button-1454703513202']/span"))) {
            methods.click(By.xpath("//*[@id='close-button-1454703513202']/span"));
            System.out.println("kampanya pop-up'i kapatildi.");
            methods.waitSeconds(1);
        }

        if (methods.isElementVisible((By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")))) {
            methods.click(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
            System.out.println("Cerezler kabul edildi.");
            methods.waitSeconds(1);
        }

        Assertions.assertEquals("https://www.setur.com.tr/", webDriver.getCurrentUrl());
        System.out.println("Acilan sayfanin Setur'a ait URL oldugu kontrol edildi.");

        Assertions.assertEquals((methods.getText(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div[1]/span[1]"))), "Kişi, Oda Sayısı");
        System.out.println("Default olarak Otel tabının geldigi teyit edildi.");

        methods.sendKeys(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/input"), methods.readCSV());
        System.out.println("Nereye Gideceksiniz alanina CSV dosyasindan okunan sehir yazildi");
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/input"));
        System.out.println("Listenin acilmasi icin textboxa tiklandi");
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div/ul/div[1]/div/div/span/strong"));
        System.out.println("Listede Antalya secildi");
        methods.waitSeconds(1);

        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[2]"));
        System.out.println("Takvime tiklanir");
        methods.waitSeconds(2);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]"));
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]"));
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]"));
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]"));
        methods.waitSeconds(1);
        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]"));
        methods.waitSeconds(1);
        System.out.println("Nisan ayina gelene kadar ilerletildi.");
        Assertions.assertEquals(methods.getText(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/strong")), "Nisan 2024");
        System.out.println("Takvimde Nisan 2024 geldigi kontrol edildi.");
        methods.clickWithJS(methods.findElement(By.cssSelector("[aria-label='Choose Pazartesi, 1 Nisan 2024 as your check-in date. It’s available.']")));
        methods.clickWithJS(methods.findElement(By.cssSelector("[aria-label='Choose Pazar, 7 Nisan 2024 as your check-out date. It’s available.']")));
        System.out.println("1-7 Nisan tarihleri secildi");
        methods.waitSeconds(1);

        methods.click(By.xpath("//*[@id='__next']/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div[1]/span[2]"));
        System.out.println("Kisi oda secimine tiklanir");
        methods.click(By.xpath("//*[@id='rc-tabs-0-panel-1']/div/div[1]/div/div[2]/button[2]"));
        System.out.println("Yetiskin sayisi 1 arttirilir");
        Assertions.assertEquals(methods.getText(By.xpath("//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[2]/span")), "3");
        System.out.println("Kisi sayisinin 1 arttigi kontrol edilir.");

        methods.isElementVisible(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[3]/button/span"));
        methods.click(By.xpath("//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[3]/button/span"));
        System.out.println("Ara butonunun gorunurlugu kontrol edilir ve tiklanir");
        methods.waitSeconds(10);

        String aramaSonuURL = webDriver.getCurrentUrl();
        String kontrolEdilen = "antalya";

        if (aramaSonuURL.contains(kontrolEdilen)) {
            System.out.println("URL icerisinde antalya mevcut");
        } else System.out.println("Dogru sayfada degiliz");

        methods.click(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/span/span/span")); //Random secim yapan metodu calistiramadim
        System.out.println("Diger bolgeleri goster alanindan secim yapildi");
        methods.waitSeconds(3);
        String kayitlisayi = methods.getText(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/span/span/span"));
        String parantezsizHali = kayitlisayi.substring(1, 3);
        System.out.println("Parantez icindeki deger kayit edildi:" + parantezsizHali);
        methods.waitSeconds(2);

        jsExecutor.executeScript("window.scrollBy(0, 25000);");
        methods.waitSeconds(1);

        WebElement element = methods.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/div[2]/div[7]/div[1]/span[2]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

        String kontrol = methods.getText(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/div[2]/div[7]/div[1]/span[2]"));
        Assertions.assertEquals(kontrol, parantezsizHali);
        System.out.println("Kaydedilen deger ve ekranin sonunda gelen deger esit");
        System.out.println("---Otomasyon Testi Tamamlandi---");
    }
}
