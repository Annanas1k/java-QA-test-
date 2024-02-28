package com.john.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LoginTest {
        public WebDriver driver;
        static final String USER_NAME = "raduBigChad";
        static final String USER_PASSWORD = "raduBigChad$123";

        //https://www.saucedemo.com/
        @BeforeClass
        public void setProperty(){
            WebDriverManager.chromedriver().browserVersion("122.0.6261.69").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        @Test
        public void loginTest() throws InterruptedException {
            driver.get("https://demoqa.com/login");
            LoginDemga loginDemga = new LoginDemga(driver);
            loginDemga.setUsername(USER_NAME);
            loginDemga.setUserPassword(USER_PASSWORD);
//            String actualProfileName = loginDemga.getProfileName();
//            String expectedProfileName = "raduBigChad";
//            Assert.assertEquals(actualProfileName, expectedProfileName);
        }
        @AfterClass
        public void tearDown(){
            driver.quit();
        }
}
