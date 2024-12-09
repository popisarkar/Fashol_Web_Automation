package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestApp {


    @Test
    public void OfferTest(){
        WebDriver driver = new ChromeDriver();

        try {
            // Step 2: Open the Fashol ERP login page
            driver.get("https://your-fashol-erp-url.com"); // Replace with actual URL
            driver.manage().window().maximize();

            // Step 3: Log in to the system
            driver.findElement(By.id("username")).sendKeys("your-username");
            driver.findElement(By.id("password")).sendKeys("your-password");
            driver.findElement(By.id("loginButton")).click();

            driver.get("https://your-fashol-erp-url.com/product-page");


            driver.findElement(By.id("addToCartButton")).click();


            driver.get("https://your-fashol-erp-url.com/cart");


            WebElement promoElement = driver.findElement(By.id("promoDiscount"));
            boolean promoApplied = promoElement.isDisplayed();


            if (promoApplied) {
                System.out.println(" The promo discount is still applied after expiration.");
            } else {
                System.out.println(" The promo discount is NOT applied as expected.");
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {

            System.out.println("PASS: The promo discount is NOT applied as expected.");
        } finally {

            driver.quit();
        }
    }
}
