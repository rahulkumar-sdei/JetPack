package com.org.jet

import platform.UIKit.*

class iOSStatusBarController : StatusBarController {
    override fun setStatusBarColor(color: String) {
        val parsedColor = UIColor(
            red = color.substring(1, 3).toInt(16) / 255.0,
            green = color.substring(3, 5).toInt(16) / 255.0,
            blue = color.substring(5, 7).toInt(16) / 255.0,
            alpha = 1.0
        )
        
        // Set the background color of the status bar's parent view
        val statusBarFrame = UIApplication.sharedApplication.statusBarFrame
        val statusBarView = UIView(frame = statusBarFrame)
        statusBarView.backgroundColor = parsedColor
        UIApplication.sharedApplication.keyWindow?.addSubview(statusBarView)

        // Ensure the status bar style matches the text color
        UIApplication.sharedApplication.statusBarStyle =
            if (UIColor.luminance(parsedColor) > 0.5) UIStatusBarStyleDefault
            else UIStatusBarStyleLightContent
    }
}
