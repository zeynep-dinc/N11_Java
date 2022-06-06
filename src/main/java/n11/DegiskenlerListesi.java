package n11;

import base.ActionList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DegiskenlerListesi extends ActionList {

    private DegiskenlerListesi(){
        PageFactory.initElements(driver,this);
    }

    public static DegiskenlerListesi degiskenlerListesi(){
        return new DegiskenlerListesi();
    }

    @FindBy(xpath = "//button[@id='details-button']")
    public WebElement gelismisButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    public WebElement ilerleTextElement;

    @FindBy(xpath = "//div[@class='dn-slide-body']")
    public WebElement uyariModalBox;

    @FindBy(xpath = "(//button[@class='dn-slide-deny-btn'])[1]")
    public WebElement dahaSonraButton;

    @FindBy(xpath = "//a[@class='btnSignIn']")
    public WebElement signInButton;

    @FindBy(xpath = "(//input[@id='email'])[@data-required-message='Lütfen e-posta adresinizi girin.']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[@class='menuLink user'])")
    public WebElement userNameTextElement;

    @FindBy(id = "searchData")
    public WebElement searchBox;

    @FindBy(xpath = "//a[text()='2']")
    public WebElement secondPageButton;

    @FindBy(xpath = "(//span[@class='textImg followBtn'])[3]")
    public WebElement thirdFavoriteItemTextElement;

    @FindBy(xpath = "//a[contains(text(),'Hesabım')]")
    public WebElement myAccountTextElement;

    @FindBy(xpath = "(//a[contains(text(),'Favorilerim / Listelerim')])[1]")
    public WebElement favoriteListButton;

    @FindBy(xpath = "(//h4[@class=\"listItemTitle\"])[contains(text(),'Favorilerim')]")
    public WebElement favoriteTextElement;

    @FindBy(xpath = "//span[@class='deleteProFromFavorites']")
    public WebElement deleteTextElement;

    @FindBy(xpath = "//span[@class='message']")
    public WebElement modalBoxTextElement;

    @FindBy(xpath = "//span[@class='btn btnBlack confirm']")
    public WebElement okeyButton;

    @FindBy(xpath = "(//a[@class='logoutBtn'])[contains(text(),'Çıkış Yap')]")
    public WebElement logOutButton;

}
