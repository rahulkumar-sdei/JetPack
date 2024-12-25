package com.org.jet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform