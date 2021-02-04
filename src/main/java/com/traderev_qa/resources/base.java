package com.traderev_qa.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver(String url) throws IOException {
        prop = new Properties();
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "traderev_qa" + File.separator + "resources" + File.separator + "data.properties";
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //firefox code
        } else if (browserName.equals("IE")) {
        	//	IE code
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty(url));
        return driver;
    }

    public void getScreenshot(String result) throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "ScreenShot";
        FileUtils.copyFile(src, new File(path + "screenshot.png"));

    }

    public void tearDown() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}
