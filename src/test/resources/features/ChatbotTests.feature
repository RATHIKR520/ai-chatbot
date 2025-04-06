Feature: DeepAI Chatbot Tests

  Scenario: Validate AI response to a general question
    Given I open the Personal chatbot
    When User Signs In
   # And I send the message "What is machine learning?" via UI and Dialogflow
    And I send the message "How does neural networks work?" via UI and Dialogflow
    Then The responses should be semantically similar

  #Scenario: Test fallback for nonsensical input
    #Given I open the DeepAI chatbot
    #When I send the message "xyzabc123"
    #Then The response should not be empty
#

  #Scenario: Compare response with Dialogflow
    #Given I open the DeepAI chatbot
    #When I send the message "How does neural networks work?" via UI and Dialogflow
    #Then The responses should be semantically similar