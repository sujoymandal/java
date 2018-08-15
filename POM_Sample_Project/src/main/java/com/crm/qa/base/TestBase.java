/*
 Author Sujoy
 */

package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
			try {
				prop=new Properties();
				FileInputStream ip=new FileInputStream("C:\\Users\\sujoy\\workspace\\POM_Sample_Project\\src\\main\\java\\com\\"
						+ "crm\\qa\\configuration\\config.properties");
				
					prop.load(ip);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\S E L E N I U M\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\S E L E N I U M\\gecko.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void switchToframe(){
		driver.switchTo().frame("mainpanel");
	}
	//"C:\\Users\\sujoy\\Desktop\\FreeCRM_Data.xlsx"
	public static Object[][] getTestData(String file_name,String sheet_name) throws Exception {
		File file=new File(file_name);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheet_name);
		int row=(sheet.getLastRowNum());
		int col=(sheet.getRow(0).getLastCellNum());
		Object[][] data=new Object[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		wb.close();
		return data;			
		

	}

}
