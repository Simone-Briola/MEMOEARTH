package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class Fragmentwb: Fragment(R.layout.frag_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        var wb=view.findViewById<WebView>(R.id.Wbmondo)
        wb.settings.javaScriptEnabled = true //enables js modifications
                    wb.settings.domStorageEnabled = true
                    wb.addJavascriptInterface(JS(), "Android") //makes it so that android can be recalled by javascript
                    wb.webViewClient = WebViewClient()
                    wb.loadUrl("file:///android_asset/mondo.html")
                }
        }


