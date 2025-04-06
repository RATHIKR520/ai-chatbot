package utilities;

import com.google.cloud.dialogflow.v2.*;
import com.google.cloud.dialogflow.v2.TextInput.Builder;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;

public class DialogflowClient {
    private static final String PROJECT_ID = "neuralnetworkbot-vmyp";
    private static final String LANGUAGE_CODE = "en-US";

    public static String detectIntent(String text) throws Exception {
        try (SessionsClient sessionsClient = SessionsClient.create(
            SessionsSettings.newBuilder()
                .setCredentialsProvider(() -> 
                    GoogleCredentials.fromStream(
                        new FileInputStream("src/test/resources/dialogflow-key.json")
                    )
                ).build()
        )) {
            SessionName session = SessionName.of(PROJECT_ID, "test-session");
            Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(LANGUAGE_CODE);
            DetectIntentRequest request = DetectIntentRequest.newBuilder()
                .setSession(session.toString())
                .setQueryInput(QueryInput.newBuilder().setText(textInput).build())
                .build();

            DetectIntentResponse response = sessionsClient.detectIntent(request);
            return response.getQueryResult().getFulfillmentText();
        }
    }
}