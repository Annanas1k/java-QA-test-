package com.john.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemga {

    @FindBy(xpath = "//*[@id='userName']")
    WebElement usernameElem;
    @FindBy(xpath = "//*[@id='password']")
    WebElement userPasswordElem;

    @FindBy(xpath = "//*[@id='userName-value']")
    WebElement profileNameElem;

    @FindBy(xpath = "//*[@id=\"login\"]")
    WebElement loginElem;

    WebDriver driver;
    JavascriptExecutor executor;

    public LoginDemga(WebDriver driverParam){
        driver = driverParam;
        PageFactory.initElements(driver, this);
        executor = (JavascriptExecutor) driver;
    }
    public void setUsername(String usernameParam){
        usernameElem.sendKeys(usernameParam);
    }

    public void setUserPassword(String userPasswordParram){
        userPasswordElem.sendKeys(userPasswordParram);
    }

    public void clickSubmit(){
        loginElem.click();
        scrollToElement(loginElem);
        closeAdvertisement();

    }


    public String getProfileName() throws InterruptedException {
        Thread.sleep(2000);
        return profileNameElem.getText();
    }
    public void closeAdvertisement(){
        try {
            executor.executeScript("var elem = document.getElementById('fixedban');" +
                    "elem.parentNode.removeChild(elem)");
        }catch (Exception  ignore){
            System.out.println("Ignore exception : " + ignore);
        }
    }


    public void scrollToElement(WebElement elemParam){
        executor.executeScript("arguments[0].scrollIntoView(true);", elemParam);
    }


}
