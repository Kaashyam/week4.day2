package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmet1LeafGround {
	public static void main(String[] args) {
		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		// Maximize the window
		driver.manage().window().maximize();

		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Click on open Home page to open a new window
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.close();
		driver.switchTo().window(list.get(0));

		// Find the number of opened windows
		driver.findElement(By.xpath("//button[text() = 'Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2.size());
		List<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(1));
		driver.close();
		driver.switchTo().window(list1.get(2));
		driver.close();
		driver.switchTo().window(list1.get(0));

		// Close all except this window
		driver.findElement(By.xpath("//button[text() = 'Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles3);
		for (String handle : windowHandles3) {
			if (!handle.equals(list2.get(0))) {
				driver.switchTo().window(handle);
				driver.close();

			}

		}
		driver.switchTo().window(list2.get(0));

		// Wait for 2 new windows to open
		driver.findElement(By.xpath("//button[text() = 'Wait for 5 seconds']")).click();

		driver.quit();

	}

}
