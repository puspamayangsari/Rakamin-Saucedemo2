package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user access the swag labs web")
    public void user_access_the_swag_labs_web(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //maximize windows

        //Assertion

        String productPage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(productPage,"Swag Labs");
    }

    @Then("user input a registered username")
    public void user_input_a_registered_username(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input registered password")
    public void user_input_registered_password(){

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("user click login button")
    public void user_click_login_button(){

       driver.findElement(By.id("login-button")).click();
    }

    @Then("user input a unregistered username")
    public void user_input_a_unregistered_username(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user123");

    }

    @Then("user get error message")
    public void user_get_error_message(){

        String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

}
