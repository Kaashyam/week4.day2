package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3DropDown {
	public static void main(String[] args) throws InterruptedException {
		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		// Maximize the window
		driver.manage().window().maximize();

		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Select training program using index
		WebElement element1 = driver.findElement(By.id("dropdown1"));
		Select dropdown1 = new Select(element1);
		dropdown1.selectByIndex(1);

		// Select training program using text
		WebElement element2 = driver.findElement(By.name("dropdown2"));
		Select dropdown2 = new Select(element2);
		dropdown2.selectByVisibleText("Appium");

		// Select training program using text
		WebElement element3 = driver.findElement(By.id("dropdown3"));
		Select dropdown3 = new Select(element3);
		dropdown3.selectByValue("3");

		// Get the number of dropdown options
		WebElement element4 = driver.findElement(By.className("dropdown"));
		Select dropdown4 = new Select(element4);
		List<WebElement> options = dropdown4.getOptions();
		for (WebElement eachOption : options) {
			System.out.println(eachOption.getText());
		}

		// You can also use sendKeys to select
		driver.findElement(By.xpath("(//div[@class='example'])[5]//select")).sendKeys("Selenium");

		// Select your programs
		WebElement element5 = driver.findElement(By.xpath("(//div[@class='example'])[6]//select"));
		Select dropdown5 = new Select(element5);
		dropdown5.selectByValue("1");
		dropdown5.selectByIndex(3);

		Thread.sleep(3000);
		driver.close();
	}

}
