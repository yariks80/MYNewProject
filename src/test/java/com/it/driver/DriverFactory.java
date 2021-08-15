package com.it.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static com.it.common.Constants.BASE_URL;
import static com.it.common.Constants.BASE_WAIT;

public class DriverFactory {


    public static WebDriver getWebDriver() {
        WebDriver driver = null;
        String driverName = System.getProperty("driver");
        if (driverName != null) {
            if ("fireFox".equals(driverName)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("ie".equals(driverName)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("edge".equals(driverName)) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if ("chrome".equals(driverName)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(BASE_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return driver;
    }
}
