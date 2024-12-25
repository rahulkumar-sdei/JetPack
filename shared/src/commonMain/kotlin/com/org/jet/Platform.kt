package com.org.jet

interface Platform {
    val name: String
}
interface StatusBarController {
    fun setStatusBarColor(color: String) // Color as a HEX string, e.g., "#FF0000"
}
expect fun getPlatform(): Platform

expect fun getStatusBarController(): StatusBarController
