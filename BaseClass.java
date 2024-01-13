package project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
		// TODO Auto-generated method stub
		static WebDriver driver;
		public static WebDriver browserLaunch(String browser)
		{
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.chromedriver().setup();
				driver=new EdgeDriver();
				break;
			default:
				break;
			}
			return driver;
		}
		public static void maximize() {
			driver.manage().window().maximize();
		}
		public static void implicitTime() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		public static void urlLaunch(String url) {
			driver.get(url);
		}
		public static WebElement sendKey(WebElement e,String value) {
			e.sendKeys(value);
			return e;
		}
		
		public static WebElement click(WebElement e) {
			e.click();
			return e;
		}
		
		public static String getText(WebElement e) {
			String text=e.getText();
			return text;
		}
		public static String getAttribute(WebElement e,String locator) {
			String value=e.getAttribute(locator);
			return value;		
		}
		public static String currentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		public static String  Title() {
			String Tit = driver.getTitle();
			return Tit;
		}
		public static  void quit() {
			driver.quit();
		}
		public static void close()
		{
			driver.close();
		}
		public static void navigateTo(String url) {
			driver.navigate().to(url);
		}
		public static  void back() {
			driver.navigate().back();
		}
		public static  void forward() {
				driver.navigate().forward();
		}
		public static  void refresh() {
				driver.navigate().refresh();
		}
		public static  void moveToElement(WebElement e) {
			// TODO Auto-generated method stub
			Actions a=new Actions(driver);
			a.moveToElement(e).perform();
		}
		public static void dragAndDrop(WebElement source,WebElement destination) {
		// TODO Auto-generated method stub
			Actions a=new Actions(driver);
			a.dragAndDrop(source, destination);
		}
		public static void contextClick(WebElement e) {
			Actions a=new Actions(driver);
			a.contextClick(e).perform();
		}
		public static void doubleClick(WebElement e) {
			Actions a=new Actions(driver);
			a.doubleClick(e).perform();
		}
		
		
		public static void screenshot() throws IOException {
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);//source
			
			File des=new File("C:\\MavenSampleTest\\ScreenshotPics\\Screenshot.png");
			FileUtils.copyFile(src, des);	
		}
		public static void selectByIndex(WebElement e,int index) {
			Select s=new Select(e);
			s.selectByIndex(index);
		}
		public static void selectByValue(WebElement e,String value) {
			Select s=new Select(e);
			s.selectByValue(value);
		}
		public static void selectbyVisibleText(WebElement e,String value) {
			Select s=new Select(e);
			s.selectByVisibleText(value);
		}
		public static void frame(int index) {
			// TODO Auto-generated method stub
			driver.switchTo().frame(index);
		}
		public static void frame(String str) {
			// TODO Auto-generated method stub
			driver.switchTo().frame(str);
		}
		public static void frame(WebElement e) {
			// TODO Auto-generated method stub
			driver.switchTo().frame( e);
		}
		public static String getWindowHandle() {
			String id = driver.getWindowHandle();
			return id;
		}
		public static Set<String> getWindowHandles() {
			// TODO Auto-generated method stub
			Set<String> windowHandles = driver.getWindowHandles();
			return windowHandles;
		}
	

}
