package tech.geeksquad.recyte;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class BotActivity extends AppCompatActivity {

    AIConfiguration config;

    AIListener aiListener;
    AIService aiService;
    private String TAG = "bot_activity";
    private AIDataService aiDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);

        init();
    }

    private void init() {

        config = new AIConfiguration("20436a41d63641b685aa22dafc43cdcb",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiDataService = new AIDataService(this, config);

        aiService = AIService.getService(this, config);

        aiListener = new AIListener() {
            @Override
            public void onResult(AIResponse result) {
                Log.d(TAG, "onResult: " + result);
            }

            @Override
            public void onError(AIError error) {
                Log.d(TAG, "onResult: " + error);

            }

            @Override
            public void onAudioLevel(float level) {

            }

            @Override
            public void onListeningStarted() {

            }

            @Override
            public void onListeningCanceled() {

            }

            @Override
            public void onListeningFinished() {

            }
        };

        aiService.setListener(aiListener);
    }

    public void sendMessage(View view) {
        EditText messageEditText = (EditText) findViewById(R.id.message);
        String message = messageEditText.getText().toString();
        new messageSendAsyncTask().execute(message);
    }

    private class messageSendAsyncTask extends AsyncTask<String, Object, AIResponse> {
        @Override
        protected AIResponse doInBackground(String... params) {
            try {
                Log.d(TAG, "doInBackground: before call");
                AIResponse hello = aiDataService.request(new AIRequest(params[0]));
                Log.d(TAG, "doInBackground: after call");

                Log.d(TAG, "doInBackground: " + hello.getResult().getFulfillment().getSpeech());
                return hello;
            } catch (AIServiceException e) {
                Log.e(TAG, "doInBackground: ", e);
                e.printStackTrace();
            }
            return null;
        }
    }
}
