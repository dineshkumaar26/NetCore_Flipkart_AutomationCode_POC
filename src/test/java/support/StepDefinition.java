package support;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class StepDefinition 

{
	WebDriver driver = null;
	  HSSFWorkbook workbook;
	  HSSFSheet sheet;
	  HSSFCell cell;

	@Before
	public void setUpDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\SG_Automation\\chromedriver.exe");
	}

	@Given("Navigate to the flipkart")
	public void navigate_to_the_flipkart() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("HI............");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\SG_Automation\\chromedriver.exe");
		///driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		//Close the login popup and login as free user
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

	@When("Search for iphone")
	public void search_for_iphone() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("iPhones below  INR 40,000");
		driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(3000);
	}

	//@Then("user is displayed with search result")
	//public void user_is_displayed_with_search_result() {
		// Write code here that turns the phrase above into concrete actions
		//System.out.println("waste method");
		//throw new io.cucumber.java.PendingException();
		
		
		
	//}

	@Then("capture the details in CSV format")
	public void capture_the_details_in_CSV_format() throws IOException {
		
		//List<WebElement> catalogproducts = driver.findElements(By.className("bhgxx2 col-12-12"));
		List<WebElement> product = driver.findElements(By.className("_3wU53n"));
		List<WebElement> price = driver.findElements(By.className("_1vC4OE"));
		List<WebElement> rating = driver.findElements(By.className("_38sUEc"));
		
		
		System.out.println("list values 1::::::::::"+product.size());
		System.out.println("list values 2::::::::::"+rating.size());
		System.out.println("list values 3::::::::::"+price.size());
		
        
        OutputStream fileStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\d.ravichandran\\Eclipse-Workspace\\test data\\datasheet.csv"));
        Writer outStreamWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);
        BufferedWriter buffWriter = new BufferedWriter(outStreamWriter);
        
        String Pro_devicedetails = "";
        String Pro_price = "";
        String pro_ratings = "";
        int rat = 0;
        
        buffWriter.append("Device Details");
        buffWriter.append(", ");
        buffWriter.append("Price");
        buffWriter.append(", ");
        buffWriter.append("Ratings");
        buffWriter.newLine();
        buffWriter.flush();
      
        
      for(int i=0; i<product.size(); i++) {
    	   
        	 Pro_devicedetails =((WebElement) product.get(i)).getText();
        	 Pro_price =((WebElement) price.get(i)).getText();
        	 pro_ratings =((WebElement) rating.get(i)).getText();

        	 rat = pro_ratings.indexOf("Rating")-1;
        	 
        	 buffWriter.append(Pro_devicedetails);
        	 
        	 buffWriter.append(", ");
        	 buffWriter.append(Pro_price);
        	 
        	 
        	 buffWriter.append(", ");
        	 buffWriter.append(pro_ratings.substring(0, rat)); 
        	 buffWriter.newLine(); 
        	 buffWriter.flush(); 
      
      
        	        	 
        }
		 
		//driver.quit();
	}
}




