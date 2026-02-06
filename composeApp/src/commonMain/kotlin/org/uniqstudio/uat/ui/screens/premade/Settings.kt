package org.uniqstudio.uat.ui.screens.premade

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.uniqstudio.uat.ui.theme.WindowSizeClass
import org.uniqstudio.uat.ui.theme.getWindowSizeClass
import uniqapptemplate.composeapp.generated.resources.Res
import uniqapptemplate.composeapp.generated.resources.about_app
import uniqapptemplate.composeapp.generated.resources.settings
import uniqapptemplate.composeapp.generated.resources.settings_unavailable
import uniqapptemplate.composeapp.generated.resources.uniq_studio_logo

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickAbout: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                modifier = modifier,
                image = Res.drawable.uniq_studio_logo,
                text = stringResource(Res.string.settings),
                onClickBack = onClickBack,
            )
        },
        containerColor = Color.Transparent
    ) { innerpadding ->
        when (getWindowSizeClass()) {
            WindowSizeClass.Compact -> {
                SettingsCompact(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }

            WindowSizeClass.Medium -> {
                SettingsMedium(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }

            WindowSizeClass.Expanded -> {
                SettingsExpanded(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }
        }
    }
    AdaptiveFloatingActionButton(
        onClick = onClickAbout,
        icon = painterResource(Res.drawable.uniq_studio_logo),
        text = stringResource(Res.string.about_app),
    )
}

@Composable
fun SettingsCompact(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextForUI(
            text = stringResource(Res.string.settings_unavailable)
        )
    }
}

@Composable
fun SettingsMedium(
    modifier: Modifier = Modifier,
) {
    SettingsCompact(modifier)
}

@Composable
fun SettingsExpanded(
    modifier: Modifier = Modifier,
) {
    SettingsCompact(modifier)
}


