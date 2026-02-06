package org.uniqstudio.uat.ui.screens.premade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.uniqstudio.uat.ui.theme.WindowSizeClass
import org.uniqstudio.uat.ui.theme.getWindowSizeClass
import uniqapptemplate.composeapp.generated.resources.Res
import uniqapptemplate.composeapp.generated.resources.app_name
import uniqapptemplate.composeapp.generated.resources.arrow_right
import uniqapptemplate.composeapp.generated.resources.lets_start
import uniqapptemplate.composeapp.generated.resources.settings
import uniqapptemplate.composeapp.generated.resources.welcome

@Composable
fun WelcomeScreen(
    modifier: Modifier,
    onClickNext: () -> Unit,
    onClickSettings: () -> Unit
) {
    when (getWindowSizeClass()) {
        WindowSizeClass.Compact -> {
            CompactWelcomeScreen(
                modifier = modifier,
                onClickNext = onClickNext
            )
        }

        WindowSizeClass.Medium -> {
            MediumWelcomeScreen(
                modifier = modifier,
                onClickNext = onClickNext
            )
        }

        WindowSizeClass.Expanded -> {
            ExpandedWelcomeScreen(
                modifier = modifier,
                onClickNext = onClickNext,
                onClickSettings = onClickSettings
            )
        }
    }
}

@Composable
fun ExpandedWelcomeScreen(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit,
    onClickSettings: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleText(
            text = stringResource(Res.string.welcome),
            color = MaterialTheme.colorScheme.onSurface
        )
        TitleText(
            text = stringResource(Res.string.app_name),
            bold = true,
            appNameSize = true,
            color = MaterialTheme.colorScheme.primary
        )

        BlankSpaceFiller()

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SquareIconButton(
                onClick = onClickSettings,
                onLongClick = {},
                icon = Res.drawable.settings,
                text = stringResource(Res.string.settings),
                bold = true
            )
            SquareIconButton(
                onClick = onClickNext,
                onLongClick = {},
                icon = Res.drawable.arrow_right,
                text = stringResource(Res.string.lets_start),
                bold = true
            )
        }
    }
}

@Composable
fun MediumWelcomeScreen(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            TitleText(
                text = stringResource(Res.string.welcome),
                color = MaterialTheme.colorScheme.onSurface
            )
            TitleText(
                text = stringResource(Res.string.app_name),
                bold = true,
                appNameSize = true,
                color = MaterialTheme.colorScheme.primary
            )

            BlankSpaceFiller()

            NextButton(
                onClickBack = {},
                onClickNext = onClickNext
            )
        }
    }
}

@Composable
fun CompactWelcomeScreen(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            TitleText(
                text = stringResource(Res.string.welcome),
                color = MaterialTheme.colorScheme.onSurface
            )
            TitleText(
                text = stringResource(Res.string.app_name),
                bold = true,
                appNameSize = true,
                color = MaterialTheme.colorScheme.primary
            )

            BlankSpaceFiller()

            NextButton(
                onClickBack = {},
                onClickNext = onClickNext
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    CompactWelcomeScreen(
        modifier = Modifier,
        onClickNext = {}
    )
}