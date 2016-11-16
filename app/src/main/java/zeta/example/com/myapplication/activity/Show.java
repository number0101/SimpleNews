package zeta.example.com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import zeta.example.com.myapplication.R;

public class Show extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        toolbar = (Toolbar) findViewById(R.id.tb);
        toolbar.setTitle("SimpleNews");
        webView = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        webView.loadUrl(bundle.get("3gurl")+"");
        webView.setWebViewClient(new WebViewClient());
    }
}
