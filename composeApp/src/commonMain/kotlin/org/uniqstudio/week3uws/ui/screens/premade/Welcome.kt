package org.uniqstudio.week3uws.ui.screens.premade

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
import org.uniqstudio.week3uws.ui.theme.WindowSizeClass
import org.uniqstudio.week3uws.ui.theme.getWindowSizeClass
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.app_name
import uws_mobile_week3.composeapp.generated.resources.arrow_right
import uws_mobile_week3.composeapp.generated.resources.lets_start
import uws_mobile_week3.composeapp.generated.resources.settings
import uws_mobile_week3.composeapp.generated.resources.welcome

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