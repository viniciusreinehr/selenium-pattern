package steps;

import io.cucumber.java.After;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
  private final WebDriver driver = new ChromeDriver();
    
  @Given("que eu acessei o google")
  public void I_visit_google() {
    driver.get("https://www.google.com");
  }

  @When("eu busquei por {string}")
  public void search_for(String query) {
    WebElement element = driver.findElement(By.name("q"));
    // Enter something to search for
    element.sendKeys(query);
    // Now submit the form. WebDriver will find the form for us from the element
    element.submit();
  }

  @Then("o titulo da página começou com {string}")
  public void checkTitle(String titleStartsWith) {
    // Google's search is rendered dynamically with JavaScript
    // Wait for the page to load timeout after ten seconds
    try {
      Thread.sleep(5000);
      String title = driver.getTitle();
      assertEquals(title, titleStartsWith);
    } catch (Exception e) {

    }
  }

  @After()
  public void closeBrowser() {
    driver.quit();
  }
}
