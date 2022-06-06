package steps;

import base.ActionList;
import io.cucumber.java.en.Given;
import n11.DegiskenlerListesi;
import n11.SayfaBasliklariEnumList;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;
import java.util.TimeZone;

public class SenaryoStepDefs extends ActionList {

    DegiskenlerListesi degiskenlerListesi = DegiskenlerListesi.degiskenlerListesi();
    int girisDenemeSayisi=0;

    public void reklamBildirimi() {
        try {
            if (degiskenlerListesi.uyariModalBox.isDisplayed()) {
                elementToBeClickable(degiskenlerListesi.dahaSonraButton);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Given("Driver basliginin {string} oldugu kontrol edilir")
    public void sayfanin_acildigi_kontrol_edilir(String expectTitle) {
        if (driver.getTitle().equals(SayfaBasliklariEnumList.GIZLILIK_HATASI.getElementList())) {
            elementToBeClickable(degiskenlerListesi.gelismisButton);
            elementToBeClickable(degiskenlerListesi.ilerleTextElement);
        }
        waitFor(5);
        Assert.assertEquals(driver.getTitle(), SayfaBasliklariEnumList.valueOf(expectTitle).getElementList());
    }

    @Given("sayfayi yinele")
    public void sayfayi_yinele() {
        sendKeysWithActionMethod(Keys.F5);
    }

    @Given("Siteye {string} kullanici adi ve {string} sifresiyle login olunur")
    public void siteye_login_ol(String email, String pass) {
        elementToBeClickable(degiskenlerListesi.signInButton);
        while (girisDenemeSayisi<=5){
            sendKeysFunction(degiskenlerListesi.emailTextBox,email);
            waitFor(4);
            sendKeysFunction(degiskenlerListesi.passwordTextBox, pass);
            waitFor(5);
            sendKeysWithActionMethod(Keys.ENTER);
            girisDenemeSayisi++;
            System.out.println(girisDenemeSayisi);
        }
    }

    @Given("Login islemi sonucu kullanici adinin {string} oldugu kontrol edilir")
    public void login_islemi_kontrol_edilir(String userName) {
        Assert.assertEquals(degiskenlerListesi.userNameTextElement.getText(), userName);
    }

    @Given("{string} kelimesi aranir")
    public void kelimesi_aranir(String item) {
        sendKeysFunction(degiskenlerListesi.searchBox, item);
        sendKeysWithActionMethod(Keys.ENTER);
        waitFor(2);
    }

    @Given("{string} tusuna bas")
    public void tusuna_bas(String tusAdi) {
        sendKeysWithActionMethod(Keys.valueOf(tusAdi));
    }

    @Given("Arama sonuclari sayfasindan {int} sayfa acilir")
    public void arama_sonuclari_sayfasindan_sayfa_acilir(Integer int1) {
        elementToBeClickable(degiskenlerListesi.secondPageButton);
    }

    @Given("{int} sayfanin acildigi kontrol edilir")
    public void sayfanin_acildigi_kontrol_edilir(Integer sayfaNo) {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.n11.com/arama?q=Iphone&pg=2");
    }

    @Given("Sayfadaki {int} urun favorilere eklenir")
    public void sayfadaki_urun_favorilere_eklenir(Integer int1) {
        elementToBeClickable(degiskenlerListesi.thirdFavoriteItemTextElement);
    }

    @Given("Hesabim Istek Listem  Favorilerim sayfasina gidilir")
    public void hesabim_istek_listem_favorilerim_sayfasina_gidilir() {
        selectFromSelectBox(degiskenlerListesi.myAccountTextElement, "Favorilerim / Listelerim");
        //  elementToBeClickable(degiskenlerListesi.myAccountTextElement);
        //  elementToBeClickable(degiskenlerListesi.favoriteTextElement);
        waitFor(2);
        elementToBeClickable(degiskenlerListesi.favoriteTextElement);
        waitFor(2);
    }

    @Given("Eklenen urun favorilerden silinir ve {} mesaji kontrol edilir")
    public void eklenen_urun_favorilerden_silinir_ve_silme_islemi_kontrol_edilir(String mesaj) {
        elementToBeClickable(degiskenlerListesi.deleteTextElement);
        Assert.assertEquals(degiskenlerListesi.modalBoxTextElement.getText(), mesaj);
    }

    @Given("Üye cikis islemi yapilir")
    public void uye_cikis_islemi_yapilir() {
        selectFromSelectBox(degiskenlerListesi.myAccountTextElement, "Çıkış Yap");
        //  elementToBeClickable(degiskenlerListesi.myAccountTextElement);
        //  elementToBeClickable(degiskenlerListesi.logOutButton);
        waitFor(2);
    }


}
