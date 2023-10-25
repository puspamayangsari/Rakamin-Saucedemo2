package saucedemo.cucumber.stepDef;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLImageElement;

import java.util.concurrent.TimeUnit;

public class checkout {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user click Add to Cart button on one of the product")
    public void user_click_Add_to_Cart_button_on_one_of_the_product() {
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
        //Add to cart sauce labs backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    @Then("user click shopping cart icon")
    public void user_click_shopping_cart_icon(){

        driver.findElement(By.id("shopping_cart_container")).click();


    }

    @And("user click Checkout button")
    public void user_click_Checkout_button(){

        driver.findElement(By.id("checkout")).click();

    }

    @And("user input First Name")
    public void user_input_First_Name(){

        driver.findElement(By.id("first-name")).sendKeys("Puspa");
    }

    @And("user input Last Name")
    public void user_input_last_Name(){

        driver.findElement(By.id("last-name")).sendKeys("Testing Baru");
    }
    @And("user input Postalcode")
    public void user_input_Postalcode(){

        driver.findElement(By.id("postal-code")).sendKeys("10560");
    }
    @And("user click Continue button")
    public void user_click_Continue_button(){

        driver.findElement(By.id("continue")).click();
    }
    @And("user click Finish button")
    public void user_click_Finish_button(){

        driver.findElement(By.id("finish")).click();
    }
}
