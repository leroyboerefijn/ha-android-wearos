package io.homeassistant.companion.android.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import io.homeassistant.companion.android.webview.WebViewActivity

object NotificationActionContentHandler {
    private const val APP_PREFIX = "app://"

    fun openUri(context: Context, uri: String?, onComplete: () -> Unit = {}) {
        if (!uri.isNullOrBlank()) {
            val intent = when {
                uri.startsWith(APP_PREFIX) -> {
                    context.packageManager.getLaunchIntentForPackage(uri.substringAfter(APP_PREFIX))
                }
                UrlHandler.isAbsoluteUrl(uri) -> {
                    Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(uri)
                    }
                }
                else -> {
                    WebViewActivity.newInstance(context, uri)
                }
            } ?: WebViewActivity.newInstance(context)

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
            context.startActivity(intent)
            onComplete()
        }
    }
}
