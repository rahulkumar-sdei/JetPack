package com.org.jet

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController(configure = { enforceStrictPlistSanityCheck = false }) { App() }
