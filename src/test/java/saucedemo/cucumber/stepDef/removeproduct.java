package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class removeproduct {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user can click add to cart product")
    public void user_can_click_add_to_cart_product(){

        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //maximize windows

        //Assertion homepage
        String productPage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(productPage, "Swag Labs");
        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click Login Button
        driver.findElement(By.id("login-button")).click();
        //Success access product page
        driver.findElement(By.xpath("//span[@class='title']"));
        String productlistPage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(productlistPage, "Products");
        //Click add to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    @Then("user can remove the product")
    public void user_can_remove_the_product(){

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

    }
}
