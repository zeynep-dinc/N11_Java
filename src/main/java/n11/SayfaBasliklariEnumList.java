package n11;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SayfaBasliklariEnumList {
    ANASAYFA("n11.com - Hayat Sana Gelir"),
    LOGIN_SAYFASI("zeynep Dinç"),
    URUN_SAYFASI("Iphone - n11.com"),
    GIZLILIK_HATASI("Gizlilik hatası"),
    ISTEK_LISTESI("İstek Listem - n11.com");

    @Getter
    public String elementList;


}
