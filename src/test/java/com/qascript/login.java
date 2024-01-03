
package jenkins;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Java{
	public static ExtentReports extent;
	public static ExtentTest show;
	private static ChromeDriver driver;
	//private static WebDriverWait sleep;


@Test(priority=1)
public void Facility() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		extent = new ExtentReports("C:\\Users\\yashwanth.s\\eclipse-workspace\\java\\src\\main\\Images.html", true);
		show = extent.startTest("Facility");
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application");
		driver = new ChromeDriver();
		//sleep = new WebDriverWait(driver, null);
		driver.manage().window().maximize();
		show.assignAuthor("Jeeva");
		show.assignCategory("Regression");
		show.log(LogStatus.INFO, "Launching the PCM-Stage Portal");
		driver.get("https://pcm-stage.healthviewx.com/user/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text() = \"Next\"]")).click();
		Thread.sleep(7000);
    	show.log(LogStatus.INFO, show.addScreenCapture(CaptureScreen(driver))+"PCM-Stage Portal Loaded Successfully");
		driver.findElement(By.name("password")).sendKeys("payoda@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text() = \"Sign In\"]")).click();
		Thread.sleep(25000);
    	extent.endTest(show);
    	extent.flush();
}

	public static String CaptureScreen(ChromeDriver driver) throws IOException {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destinationfile = new File("src/../Report.html"+System.currentTimeMillis()+".png");
		String absolutepath_screen = Destinationfile.getAbsolutePath();
		FileUtils.copyFile(srcfile, Destinationfile);
		return absolutepath_screen;
	}	
}



