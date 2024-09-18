package dev.thororen.equicord;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class EquicordNative {
    private final WebView wv;
    private final Activity activity;

    public EquicordNative(Activity activity, WebView wv) {
        this.activity = activity;
        this.wv = wv;
    }

    @JavascriptInterface
    public void goBack() {
        activity.runOnUiThread(() -> {
            if (wv.canGoBack())
                wv.goBack();
            else
                // no idea what i was smoking when I wrote this
                activity.getActionBar();
        });
    }
}
