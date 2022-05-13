package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.amazon.in");

		// Maximize the window
		driver.manage().window().maximize();

		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Search for oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);

		// Get the price of the first product
		WebElement firstElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
		String text = firstElement.getText().toString();
		System.out.println("The price of the first oneplus 9 product is " + text);

		// Print the number of customer ratings for the product
		WebElement secondElement = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[2]"));
		System.out.println("The number of customer ratings for the product displayed is " + secondElement.getText());

		// Click the first text link
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).click();
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(window);
		driver.switchTo().window(list.get(1));

		// Take Screenshot
		File sourceImage = driver.getScreenshotAs(OutputType.FILE);
		File destImage = new File("./Screenshots/IMG001.png");
		FileUtils.copyFile(sourceImage, destImage);

		// Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(4000);

		// Get the cart total and verify if it is correct
		WebElement total = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String text1 = total.getText().toString();
		String result = text1.replaceAll("₹", "");
		String result2 = result.replaceAll(".00", "");
		System.out.println("Cart Subtotal is " + result2);
		if (result2.equalsIgnoreCase(text)) {
			System.out.println("Cart Subtotal verification sucessful");
		} else {
			System.out.println("Cart Subtotal verification failed");
		}
		Thread.sleep(2000);

		// Close the browser
		driver.quit();
	}
}
