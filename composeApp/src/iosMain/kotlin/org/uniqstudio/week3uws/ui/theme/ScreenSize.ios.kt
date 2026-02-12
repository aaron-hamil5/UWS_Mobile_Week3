package org.uniqstudio.week3uws.ui.theme

import androidx.compose.runtime.Composable
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun getWindowSizeClass(): WindowSizeClass {
    val width = UIScreen.mainScreen.bounds.useContents { size.width }

    return if (width <= 600){ WindowSizeClass.Compact }
    else if (width <= 840){ WindowSizeClass.Medium }
    else { WindowSizeClass.Expanded }
}