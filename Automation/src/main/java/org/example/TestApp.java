package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class TestApp {


    @Test
    public void OfferTest(){
        WebDriver driver = new ChromeDriver();

        try {
            //open browser
            driver.get("https://your-fashol-erp-url.com");
            driver.manage().window().maximize();

            // log in ERP system
            driver.findElement(By.id("email")).sendKeys("popi@gmail.com");
            driver.findElement(By.id("password")).sendKeys("123456");
            driver.findElement(By.id("loginButton")).click();

            // go to product page
            driver.get("https://your-fashol-erp-url.com/product-page");
            driver.findElement(By.id("addToCartButton")).click();
            // add to cart product
            driver.get("https://your-fashol-erp-url.com/cart");

            // check discount expiration
            WebElement promoElement = driver.findElement(By.id("promoDiscount"));
            boolean promoApplied = promoElement.isDisplayed();

            if (promoApplied) {
                System.out.println(" The promo discount is still applied after expiration.");
            } else {
                System.out.println(" The promo discount is not  applied as expected.");
            }
        } catch (NoSuchElementException e) {

            System.out.println(" The promo discount is not applied as expected.");
        }

        // close browser
        finally {

            driver.quit();
        }
    }
}
