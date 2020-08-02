package newWebautomationPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class launchBrowser {

	public static WebDriver driver = null;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubong\\eclipse-workspace\\selenium_java\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// open the web application
		driver.navigate().to("https://www.varsitytutors.com/tutoring_opportunities");
		driver.manage().window().maximize();

		// Search for User name and send keys
		WebElement username = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/label/input"));
		username.sendKeys("ein170000@utdallas.edu");

		// Search for password and input
		WebElement password = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[1]/label[1]/input"));
		password.sendKeys("J+3448f[Zyhg+E,ZTx");

		// Submit user name and password to server and wait for authentication
		WebElement submit = driver.findElement(By.xpath("/html/body/main/div/form/fieldset/div[1]/button"));
		submit.click();
		
		
		boolean x = true;
		
		
		// instant session full xpath to join WITHOUT 15 second wait: /html/body/div[5]/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/button
		// instant session full xpath to join WITH 15 second wait:
		// instant session class = 
		// instant session full XPATH = /html/body/main/div/div/div/div[2]/div/table/tbody/tr/td[8]/a
		// <span class="toggle-interest__label">Interested</span>
		// Output the time that we started looking for opportunities
		System.out.println("We began searching for opportunities at: " + java.time.LocalTime.now());
		
		while (x) {
			try {
				
				// Browser waits 30 minutes for element before throwing Timeout Exception
				WebDriverWait wait = new WebDriverWait(driver, 1800);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/div/div[2]/div/table/tbody/tr/td[8]/a")));
				
				// Selenium then clicks on found element
				WebElement element = driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/div/table/tbody/tr/td[8]/a"));
				element.sendKeys(Keys.ENTER);
				
				/* Immediately join tutoring session that requires no wait: Implemented this part of the code when I found out 
				that I would not be able to click on the join now button at a quick enough rate without the 15 second wait*/
				WebElement joinNow = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/button"));
				joinNow.click();
				
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", element);
				
				// Display that you have found an opportunity
				System.out.println("OPPORTUNITY FOUND!!!!");
				
				break;
				
//				WebElement opportunity = driver.findElement(By.className("btn more-info js-instant-session-dialog"));
//				opportunity.click();

			} catch (Exception ex) {
				
				System.out.println("No opportunities were found in the last 30 minutes" + "\n" +  "The time is " + java.time.LocalTime.now());

			}

		}
	}
}
