package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;   // logging
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static Logger logger; // for logging
	
	public Properties p;
	final String folderTimeStamp = new SimpleDateFormat("yyyyMMddhh").format(new Date());

	
	//public static ResourceBundle rb = ResourceBundle.getBundle("config");;

	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br, String os) throws IOException
	{
		//Loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		//Loading log4j2 file
		logger=LogManager.getLogger(this.getClass());  //logging
		//rb = ResourceBundle.getBundle("config");  // load config.properties file

		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No matching browser");return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			if(br.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(br.equals("edge")) {
				driver = new EdgeDriver();
			}
			else {
				driver = new ChromeDriver();
			}
		}

		
		// deleting all cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for all webelements
		
		//driver.get(rb.getString("appURL"));
		driver.get(p.getProperty("appURL"));
		
		driver.manage().window().maximize(); // maximizing the window
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();  // closing the browser
	}
	
//	public String getSearchText() {
//		return rb.getString("search");
//	}
	
	public int randomNumber() {
		Random random = new Random();
		int generatedNumber = random.nextInt(100);
		return (generatedNumber);
	}
	
	public int getRandom(int size) {
		Random random = new Random();
		int generatedNumber = random.nextInt(size);
		return generatedNumber;
	} 
	
	public String captureScreen(String fname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\"+ folderTimeStamp +"\\" + fname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
