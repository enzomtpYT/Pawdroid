package dev.thororen.equidroid;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class EquidroidNative {
    private final WebView wv;
    private final Activity activity;

    public EquidroidNative(Activity activity, WebView wv) {
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
