package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2Frames {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.switchTo().frame("frame1");
	driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Topic1");
	driver.switchTo().frame("frame3");
	driver.findElement(By.id("a")).click();
	driver.switchTo().parentFrame();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frame2");
	WebElement findElement = driver.findElement(By.id("animals"));
	Select sel = new Select(findElement);
	sel.selectByValue("avatar");
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	driver.close();
}
}
