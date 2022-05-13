package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertsAndFrames {

	public static void main(String[] args) throws InterruptedException {
		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Maximize the window
		driver.manage().window().maximize();

		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Switch the context from web page to frame
		driver.switchTo().frame("iframeResult");

		// Click the button to trigger the alert
		driver.findElement(By.xpath("//button[contains(text(), 'Try')]")).click();

		// Switch back to default context
		// driver.switchTo().defaultContent();

		// Switch the context from web page to alert
		Alert promptAlert = driver.switchTo().alert();

		// Get text from the alert box and print
		String promptText = promptAlert.getText();
		 System.out.println(promptText);

		// Enter the value in the alert text box
		promptAlert.sendKeys("Shyam");

		// Accept the alert
		promptAlert.accept();

		// Get the text displayed and verify the name
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		if (text.contains("Shyam")) {
			System.out.println("The text contains my name");
		}
		
		Thread.sleep(2000);
		driver.close();

	}
}
