package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {


private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

public static WebDriver getDriver() {

    if (driverPool.get() == null) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driverPool.set(driver);
    }
    return driverPool.get();
}


public static void closeDriver() {
    if (driverPool.get() != null) {
        driverPool.get().close();
        driverPool=null;
    }
}


public static void quitDriver() {
    if (driverPool.get() != null) {
        driverPool.get().quit();
        driverPool=null;
    }
}
}


