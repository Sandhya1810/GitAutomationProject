package RadioButton;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton1 {
	
		int a; Integer b;
	
	public static void main(String[] args) throws Exception {
		
		//WebDriver driver;
		File source = new File("D:\\Softwares\\JavaWorkspace\\ActionEvents\\Repository\\Objects.properties");
		
		FileInputStream fis = new FileInputStream(source);
		
		Properties pr = new Properties();
		pr.load(fis);
		
		//String s = "Male";
		
		//.RadioButtonstring s = "Male";
		
		//ArrayList<Integer> li = new ArrayList<Integer>();
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JavaWorkspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(pr.getProperty("FaceBookURL"));
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.navigate().refresh();
				
		driver.findElement(By.xpath(pr.getProperty("CreateNewAccount"))).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("u_1_b")).sendKeys(pr.getProperty("Login1"));
		
		//1st way normal click 
		driver.findElement(By.xpath(pr.getProperty("FemaleRadioButton"))).click();
		
		driver.findElement(By.xpath(pr.getProperty("MaleRadioButton"))).click();		
		
		driver.findElement(By.xpath(pr.getProperty("CustomRadioButton"))).click();
		
		// 2nd way Click on multiple web elements
		 
		/*List <WebElement> radio = driver.findElements(By.xpath(pr.getProperty("ListOfRadioButtons")));
		System.out.println("Total number of radio buttons:" +radio.size());
		System.out.println("Success");
		
		System.out.println(radio.get(0).isDisplayed());
		System.out.println(radio.get(1).isSelected());
		System.out.println(radio.get(2).isEnabled());*/
		
		//3rd way click on same button
		
		List <WebElement> radio1 = driver.findElements(By.xpath(pr.getProperty("LabelsOfRadioButtons")));
		String ExpectedResult = "Male";
				//test
		for(int i=0; i<radio1.size(); i++)
			
			
		{
			if(radio1.get(i).getText().equalsIgnoreCase(ExpectedResult))
			{
				radio1.get(i).click();
				
				System.out.println(ExpectedResult + "  Clicked");
			}
			
		}
		
		driver.quit();
	}

}
