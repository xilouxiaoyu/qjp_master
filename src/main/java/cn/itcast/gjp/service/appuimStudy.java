package cn.itcast.gjp.service;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 * @author apple
 * @date 2019/10/31 上午11:53
 */
public class appuimStudy {
    private AppiumDriver driver;
    public By findElement(String findBy, String value){
        By by;
        switch (findBy){
            case "id":
                by= MobileBy.id(value);
                break;
            case "xpath":
                by=MobileBy.xpath(value);
            default:
                throw new RuntimeException("暂不支持: " + findBy);
        }
        return by;
    }

    public  WebElement waitForElementVisible(String findBy,String value,
                                             String maxWaitTimeInSeconds){

        return null;
        //new WebDriverWait(driver, Long.parseLong(maxWaitTimeInSeconds)).until(presenceOfElementLocated(findElement(findBy, value)));
    }
    public void switchWindows(String window){
        driver.switchTo().window(window);

    }

}
