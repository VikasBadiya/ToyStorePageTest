package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try{
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://qatoystore.ccbp.tech/");
            String parentWindowHandle = driver.getWindowHandle();
            driver.findElement(By.className("product")).click();

            Set<String> WindowHandleSet = driver.getWindowHandles();
            System.out.println(WindowHandleSet);
            for(String WindowHandle: WindowHandleSet ){
                if(!WindowHandle.equals(parentWindowHandle)){
                    driver.switchTo().window(WindowHandle);
                    //Print the product name.
                    String ProductName= driver.findElement(By.className("product-name")).getText();
                    System.out.println(ProductName);

                    //Print the product price.
                    String ProductPrice = driver.findElement(By.className("price-details")).getText();
                    System.out.println(ProductPrice);
                    //Print the product description.
                    String ProductDescription = driver.findElement(By.className("product-description")).getText();
                    System.out.println(ProductDescription);
                    //Close the child window.
                    driver.close();
                }
            }

            //Quit the parent window.
            driver.quit();
        }catch(Exception e){
            System.out.println("Error Message of "+ e);
        }



    }
}