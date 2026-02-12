package org.uniqstudio.week3uws.ui.theme

import androidx.compose.runtime.Composable

enum class WindowSizeClass {
    Compact, Medium, Expanded
}

@Composable
expect fun getWindowSizeClass(): WindowSizeClass