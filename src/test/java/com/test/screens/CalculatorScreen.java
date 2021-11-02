package com.test.screens;

import com.test.Configurations.FlickrAPIProcessor;
import com.test.Configurations.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class CalculatorScreen {

	private AndroidDriver driver;
	private FlickrAPIProcessor flickrAPIProcessor;

	/*
	 * Search Screen constructor initializes screen elements
	 */
	public CalculatorScreen() {
		this.driver = new Hooks().getDriver();

	}

	public void ClickWholeEquation(String equation) {
		// todo: filter only acceptable chars
		for (char character : equation.trim().toCharArray()) {
			try {
				ClickElement(character);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public String appLaunched() {

		WebElement inputData = driver.findElement(By.id("com.google.android.calculator:id/mode"));
		String inputText = inputData.getText();
		System.out.println(" Text ...." + inputText);
		return inputText;

	}

	public void operation() throws InterruptedException {

		WebElement inputData = driver.findElement(By.id("com.google.android.calculator:id/mode"));
		String inputText = inputData.getText();
		System.out.println(" Text ...." + inputText);

		WebElement inputData1 = driver.findElement(By.id("com.google.android.calculator:id/pad_basic"));
		inputData1.click();
		Thread.sleep(100);
		WebElement inputData3 = driver.findElement(By.id("com.google.android.calculator:id/op_pow"));
		/*
		 * inputData3.click(); //com.google.android.calculator:id/op_pow
		 * //com.google.android.calculator:id/op_add Thread.sleep(100);
		 * 
		 * inputData1.click();
		 * 
		 * WebElement inputData2=
		 * driver.findElement(By.id("com.google.android.calculator:id/eq"));
		 * inputData2.click();
		 */

	}

	public void ClickElement(char character) throws InterruptedException {
		// Without explicit char parsing, it should be faster.
		
		switch ((int) character) {
		case 37:
			WebElement Percent = driver.findElement(By.id(""));
			Thread.sleep(1000);
			Percent.click();
			break;

		case 42:
			WebElement Multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
			Thread.sleep(1000);
			Multiply.click();
			break;

		case 43:
			
			WebElement Plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
			Thread.sleep(1000);
			Plus.click();
			break;

		case 45:
			WebElement Minus = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
			Thread.sleep(1000);
			Minus.click();
			break;

		case 47:
			WebElement devide = driver.findElement(By.id("com.google.android.calculator:id/op_div"));
			Thread.sleep(1000);
			devide.click();
			break;

		case 48:
			WebElement num0 = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
			Thread.sleep(1000);
			num0.click();
			break;

		case 49:
			WebElement Number1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
			Thread.sleep(1000);
			Number1.click();
			break;

		case 50:
			
			WebElement Number2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
			Thread.sleep(1000);
			Number2.click();
			break;

		case 51:
			WebElement Number3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
			Thread.sleep(1000);
			Number3.click();
			break;

		case 52:
			WebElement Number4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
			Thread.sleep(1000);
			Number4.click();
			break;

		case 53:
			WebElement Number5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
			Thread.sleep(1000);
			Number5.click();
			break;

		case 54:
			WebElement Number6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
			Thread.sleep(1000);
			Number6.click();
			break;

		case 55:
			WebElement Number7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
			Thread.sleep(1000);
			Number7.click();
			break;

		case 56:
			WebElement Number8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
			Thread.sleep(1000);
			Number8.click();
			break;

		case 57:
			WebElement Number9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
			Thread.sleep(1000);
			Number9.click();
			break;

		case 61:
			WebElement Equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
			Thread.sleep(1000);
			Equal.click();
			break;
		case 94:
			rightLeftSwipe(1000);
			Thread.sleep(1000);
			WebElement power = driver.findElement(By.id("com.google.android.calculator:id/op_pow"));
			Thread.sleep(1000);
			power.click();
			Thread.sleep(1000);
			WebElement arrow = driver.findElement(By.id("com.google.android.calculator:id/arrow"));
			arrow.click();
			break;
		

		}
	}

	public String getResult() {

		String result = "";
		WebElement resultLoc = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		result = resultLoc.getText();
		return result;

	}

	public String errorMsg() {

		String msg = "";
		WebElement resultLoc = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		msg = resultLoc.getText();
		return msg;

	}

	public void leftRightSwipe(int timeduration) {
		// duration should be in milliseconds
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.30);
		int endx = (int) (size.width * 0.95);
		int starty = size.height / 2;
		System.out.println("Start swipe operation");
		driver.swipe(endx, starty, startx, starty, timeduration);

	}

	public void rightLeftSwipe(int timeduration) {

		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int) (size.width * 0.95);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		System.out.println("Start swipe operation");
		driver.swipe(startx, starty, endx, starty, timeduration);

	}
	
	public void clearScreen(){
				
		WebElement resultField= driver.findElement(By.id("com.google.android.calculator:id/formula"));
		String text= resultField.getText();
		WebElement clearText= driver.findElement(By.id("com.google.android.calculator:id/del"));
		for (char character : text.trim().toCharArray()) {
			
			clearText.click();
		}
		
	}

}
