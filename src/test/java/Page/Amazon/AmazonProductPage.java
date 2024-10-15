package Page.Amazon;


import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonProductPage {

    public AmazonProductPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    public WebElement cookies;

    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy (xpath = "//div//span[text()='\"iPhone\"']")
    public WebElement resultiPhone;

    @FindBy (xpath = "//select[@id='searchDropdownBox']")
    public WebElement searchDropdownBox;

    @FindBy (xpath = "//option[@value='search-alias=computers']")
    public WebElement computers;

    @FindBy (xpath = "//div//span[text()='\"macbook\"']")
    public WebElement resultComputers;

    @FindBy (xpath ="(//button[text()='Sepete ekle'])")
    public List<WebElement> addToCart;

    @FindBy (xpath = "//a[contains (text(), 'Sepete Git')]")
    public WebElement goToCart;

    @FindBy (xpath="//span[@class=('a-dropdown-prompt') and text()='1']")
    public WebElement quantity;

    @FindBy (xpath = "//input[@value='Sil']")
    public WebElement delete;

    @FindBy (xpath = "//h2[contains (text(), \'Amazon sepetiniz boş.\')]")
    public WebElement deleteMessage;

    @FindBy (xpath="//a[@data-csa-c-content-id=\'nav_cs_bestsellers\']")
    public WebElement bestSeller;

    @FindBy (xpath="//span[@id='zg_banner_text']")
    public WebElement bestSellerPage;

    @FindBy (xpath = "//span[contains(text(), 'Başa dön')]")
    public WebElement backToTop;











}
