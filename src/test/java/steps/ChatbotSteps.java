package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.reporters.*;
import pages.ChatbotPage;
import utilities.DialogflowClient;
import java.util.Map;
import java.util.HashMap;
import static org.testng.Assert.fail;
import java.util.Arrays;
import java.util.List;

public class ChatbotSteps {
    WebDriver driver;
    ChatbotPage chatbotPage;
    long startTime;

    @Given("I open the Personal chatbot")
    public void openChatbot() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        chatbotPage = new ChatbotPage(driver);
    }
    //Sign In
    @When("User Signs In")
    public void signin() {
    	chatbotPage.SignIn(driver);
    }
    
    
    
    
 // Add this step to compare responses
    @And("I send the message {string} via UI and Dialogflow")
    public void sendMessageToBoth(String message) throws Exception {
        // Send to DeepAI UI
    	
        chatbotPage.sendMessage(message);
        String uiResponse = chatbotPage.getLatestResponse();
         System.out.println(uiResponse);
        // Send to Dialogflow
        String dialogflowResponse = DialogflowClient.detectIntent(message);

        // Store responses for comparison
        ScenarioContext.setResponse("UI", uiResponse);
        ScenarioContext.setResponse("Dialogflow", dialogflowResponse);
        System.out.println(dialogflowResponse);
        
        Reporter.log("UI Response" +uiResponse);
        Reporter.log("dialogflowResponse" +dialogflowResponse);
    }

    @Then("The responses should be semantically similar")
    public void validateSemanticSimilarity() {
        String uiResponse = ScenarioContext.getResponse("UI");
        String dialogflowResponse = ScenarioContext.getResponse("Dialogflow");
         if(uiResponse.equals(dialogflowResponse)) {
        	 
             Reporter.log("Trained Data is Matching");	 
             Assert.assertTrue(true);
         }
         else {
        	 
             Reporter.log("Responses don't match expected topic");	 
             Assert.assertTrue(false);
         }
        // Basic keyword comparison (enhance with NLP libraries if needed)
//        Assert.assertTrue(
//            uiResponse.contains("Machine learning") || 
//            dialogflowResponse.contains("Machine learning"),
//            "Responses don't match expected topic"
//        );
        
        driver.quit();
    }

    // Utility class to share data between steps
    public class ScenarioContext {
        private static Map<String, String> responses = new HashMap<>();

        public static void setResponse(String source, String response) {
            responses.put(source, response);
        }

        public static String getResponse(String source) {
            return responses.get(source);
        }
    }
}