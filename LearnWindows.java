package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {
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
		System.out.println(windowHandles);

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		String newWindowHandle = windowHandlesList.get(1);
		System.out.println("--------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("--------------------------------------------------");
		driver.switchTo().window(newWindowHandle);

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("--------------------------------------------------");
		driver.switchTo().window(windowHandlesList.get(0));

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.quit();
	}
}
