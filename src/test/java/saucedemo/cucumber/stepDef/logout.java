package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User can click burger menu")
    public void user_can_click_burger_menu() {

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
        //Click button burger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User can click button logout")
    public void user_can_click_button_logout() {

        driver.findElement(By.id("menu_button_container")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User successfully logout")
    public void user_successfully_logout() {
        String sauceDemo = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(sauceDemo, "Accepted usernames are:");
        driver.close();
    }
}
