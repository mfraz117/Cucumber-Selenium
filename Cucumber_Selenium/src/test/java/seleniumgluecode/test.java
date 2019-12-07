package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
	
	public static WebDriver driver;
    @Given("^User is  on the home page$")
    public void user_is_on_the_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver 2");
    	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.id("email")).click();
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	//send input from excel, try a dataprovider
    	//after excel, send data directly from the feature.
    	driver.findElement(By.id("email")).sendKeys("fraz5117@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("Shaista117");
        driver.findElement(By.id("loginbutton")).click();   
    }
    
    @Then("^user logs into facebook$")
    public void user_logs_into_facebook() throws Throwable {
    	String afterLoginTitle = driver.getTitle();
    	System.out.println(afterLoginTitle);
    	String actualTitle =driver.getTitle();
        Assert.assertEquals(afterLoginTitle, actualTitle);
        driver.quit();  
    }      

}
