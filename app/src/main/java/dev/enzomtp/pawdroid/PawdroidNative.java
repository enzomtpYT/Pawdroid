package dev.enzomtp.pawdroid;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class PawdroidNative {
    private final WebView wv;
    private final Activity activity;

    public PawdroidNative(Activity activity, WebView wv) {
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
