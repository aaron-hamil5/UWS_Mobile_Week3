package org.uniqstudio.week3uws

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import org.uniqstudio.week3uws.ui.screens.UniqApp
import org.uniqstudio.week3uws.ui.theme.AppTheme

@Preview
@Composable
fun App() {
    AppTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            UniqApp()
        }
    }
}