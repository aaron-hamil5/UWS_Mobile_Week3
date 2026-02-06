package org.uniqstudio.uat.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun getWindowSizeClass(): WindowSizeClass {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp

    return when {
        screenWidthDp < 600 -> WindowSizeClass.Compact
        screenWidthDp < 840 -> WindowSizeClass.Medium
        else -> WindowSizeClass.Expanded
    }
}