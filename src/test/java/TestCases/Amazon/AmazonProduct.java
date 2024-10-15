package TestCases.Amazon;

import Page.Amazon.AmazonProductPage;
import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.time.Duration;

public class AmazonProduct {


    @Test (priority = 0)
    void amazonSearchProduct() throws InterruptedException {

        AmazonProductPage amazonProductPage = new AmazonProductPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5L));

        Driver.getDriver().get("https://www.amazon.com.tr/");

        amazonProductPage.cookies.click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.searchBox));
        amazonProductPage.searchBox.sendKeys("iPhone", Keys.ENTER);

        String expectedData = "iPhone";
        String actualData = amazonProductPage.resultiPhone.getText();
        Assert.assertTrue(actualData.contains(expectedData));
        System.out.println(actualData);

        Driver.quitDriver();

    }

    @Test (priority = 1)
    void addToBoxAndDeleteFromCart() throws InterruptedException {

        AmazonProductPage amazonProductPage = new AmazonProductPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5L));

        Driver.getDriver().get("https://www.amazon.com.tr/");

        amazonProductPage.cookies.click();

        amazonProductPage.searchDropdownBox.click();

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.computers));
        amazonProductPage.computers.click();

        amazonProductPage.searchBox.sendKeys("macbook", Keys.ENTER);
        String expectedData = "macbook";
        String actualData = amazonProductPage.resultComputers.getText();
        Assert.assertTrue(actualData.contains(expectedData));
        System.out.println(actualData);

        amazonProductPage.addToCart.getFirst().click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.goToCart));
        amazonProductPage.goToCart.click();

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.quantity));

        amazonProductPage.delete.click();

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.deleteMessage));
        String expectedMessage = "Amazon sepetiniz boş.";
        String actualMessage = amazonProductPage.deleteMessage.getText();

        if ((actualMessage.contains(expectedMessage))){

            Assert.assertTrue(true);
            System.out.println("Test Başarılı");
        } else {
            Assert.fail("Test Başarısız");

        }

        Driver.quitDriver();

    }

    @Test (priority = 2)
    void theBestSellerPage () throws InterruptedException {

        AmazonProductPage amazonProductPage = new AmazonProductPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5L));
        Driver.getDriver().get("https://www.amazon.com.tr/");

        amazonProductPage.cookies.click();

        System.out.println("Homepage : " + Driver.getDriver().getTitle());
        if (Driver.getDriver().getTitle().contains("Amazon")){
            System.out.println("Home page is visible ");
        }else {
            System.out.println("Actual : " + Driver.getDriver().getTitle());
        }

        wait.until(ExpectedConditions.visibilityOf(amazonProductPage.bestSeller));
        amazonProductPage.bestSeller.click();
        Thread.sleep(1500);

        String expectedPage = "Çok Satanlar";
        String actualPage = amazonProductPage.bestSellerPage.getText();
        Assert.assertTrue(actualPage.contains(expectedPage));

        js.executeScript("arguments[0].scrollIntoView();", amazonProductPage.backToTop);
        Thread.sleep(1500);

        amazonProductPage.backToTop.click();

        Driver.quitDriver();

    }



}
