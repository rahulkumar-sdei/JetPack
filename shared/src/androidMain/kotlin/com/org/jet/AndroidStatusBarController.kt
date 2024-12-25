package com.org.jet

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View

class AndroidStatusBarController(private val activity: Activity) : StatusBarController {
    override fun setStatusBarColor(color: String) {
        val window = activity.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor(color)
        }

        // Optional: Set light or dark status bar icons
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val isLightColor = Color.luminance(Color.parseColor(color)) > 0.5
            decorView.systemUiVisibility = if (isLightColor) {
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }
}
