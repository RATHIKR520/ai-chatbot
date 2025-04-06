package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ChatbotPage {
    WebDriver driver;
    WebDriverWait wait;
    
    // DeepAI Chatbot Locators
    By chatInput = By.cssSelector("input[placeholder='Send a message...']");
    By sendButton = By.xpath("//*[@class='send-icon material-icons']");
    By chatResponse = By.xpath("//div[@data-type='INPUT_MESSAGE']//following::div[@data-type='BOT_RESPONSE_text']");
    By userId=By.xpath("//*[@name='email']");
    By password=By.xpath("//*[@name='password']");
    By Login_btn=By.xpath("//*[@type='submit']");
    By Chatbot_btn=By.xpath("//button[@class='tpl-button-round test-your-bot-button']");
    
    public  ChatbotPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://app.chatbot.com/dashboard/67ebba4da5527c00070885c8/");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(chatInput));
        Reporter.log("Application Lauched");
    }
    
    

	public void SignIn(WebDriver driver) {
    	try {
    	Thread.sleep(6000);
    	driver.findElement(userId).sendKeys("rathikp22@gmail.com");
    	Thread.sleep(5000);
    	driver.findElement(password).sendKeys("9731720990");
    	Thread.sleep(2000);
    	driver.findElement(Login_btn).click();
    	  Reporter.log("Sign In Sucessful");
    	
    	}
     catch(InterruptedException e) {
    	 
    	 e.printStackTrace();
     }
    		
    	}
    

    public void sendMessage(String message) {
    	try {
    		Thread.sleep(2000);
    	driver.findElement(Chatbot_btn).click();
    	Thread.sleep(2000);
        driver.findElement(chatInput).sendKeys(message);
        Thread.sleep(2000);
        driver.findElement(sendButton).click();
        Thread.sleep(4000);
        waitForResponse();
        Reporter.log("Intraction Sucessful with Chatbot");
    
	}
    catch(InterruptedException e) {
   	 
   	 e.printStackTrace();
    }
 }
    	

    public String getLatestResponse() {
        return driver.findElement(chatResponse).getText();
    }

    private void waitForResponse() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(chatResponse, ""));
    	//String chatcontent =driver.findElement(chatResponse).getText();
       // System.out.println(chatcontent);
    }
    
}