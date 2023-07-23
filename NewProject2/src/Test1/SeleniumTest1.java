package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

public class SeleniumTest1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\eclipse-workspace\\NewProject1\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://todomvc.com/examples/knockoutjs/");
		
		driver.manage().window().maximize();
		
		//Menambahkan to-do item 
		WebElement textbox = driver.findElement(By.className("new-todo"));
        textbox.sendKeys("Belajar", Keys.ENTER);
        Thread.sleep(2000);
        textbox.sendKeys("Membaca", Keys.ENTER);
        Thread.sleep(2000);
        textbox.sendKeys("Makan", Keys.ENTER);
        Thread.sleep(2000);
        
        //Menyelesaikan to-do item
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), 'Membaca')]/preceding-sibling::input"));
        checkbox.click();
        Thread.sleep(2000);
        WebElement todoList = driver.findElement(By.xpath("//label[contains(text(), 'Belajar')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(todoList).perform();
        
        //Hapus to-do item 
        WebElement delete = driver.findElement(By.xpath("//label[contains(text(), 'Belajar')]/following-sibling::button"));
        delete.click();
        Thread.sleep(2000);
        
        
        //Filter to-do item 
        WebElement filterCompleted = driver.findElement(By.xpath("//a[contains(text(), 'Completed')]"));
        filterCompleted.click();
        Thread.sleep(2000);
        
     
        
        
        
        
        
		
		driver.quit();
	}

}