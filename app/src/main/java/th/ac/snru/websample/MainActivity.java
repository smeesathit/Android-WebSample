package th.ac.snru.websample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        // prevent openning web browser
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        Button goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText urlEditText = findViewById(R.id.urlEditText);
                String url = urlEditText.getText().toString().trim();

                if (!url.equals("")) {
                    if (!url.toLowerCase().startsWith("http://")){
                        url = "http://" + url;
                    } else if (!url.toLowerCase().contains("www")){
                        url = "http://www." + url.substring(7, url.length());
                    }
                    urlEditText.setText(url);
                    webView.loadUrl(url);
                } // end if
            }
        });
    }
}
