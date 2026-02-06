package org.uniqstudio.uat.ui.screens.premade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.uniqstudio.uat.ui.theme.WindowSizeClass
import org.uniqstudio.uat.ui.theme.getWindowSizeClass
import uniqapptemplate.composeapp.generated.resources.Res
import uniqapptemplate.composeapp.generated.resources.about_app
import uniqapptemplate.composeapp.generated.resources.about_creator_title
import uniqapptemplate.composeapp.generated.resources.about_disclaimer
import uniqapptemplate.composeapp.generated.resources.about_disclaimer_text
import uniqapptemplate.composeapp.generated.resources.about_resources
import uniqapptemplate.composeapp.generated.resources.about_resources_text
import uniqapptemplate.composeapp.generated.resources.about_text
import uniqapptemplate.composeapp.generated.resources.settings
import uniqapptemplate.composeapp.generated.resources.uniq_studio_logo

@Composable
fun AboutScreen(
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
                AboutCompact(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }

            WindowSizeClass.Medium -> {
                AboutCompact(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }

            WindowSizeClass.Expanded -> {
                AboutExpanded(
                    modifier = modifier.fillMaxSize().padding(innerpadding)
                )
            }
        }
    }
    AdaptiveFloatingActionButton(
        onClick = onClickAbout,
        icon = painterResource(Res.drawable.uniq_studio_logo),
        text = stringResource(Res.string.about_creator_title),
    )
}

@Composable
fun AboutCompact(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        TitleAndParagraph(
            title = stringResource(Res.string.about_app),
            text = stringResource(Res.string.about_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = stringResource(Res.string.about_resources),
            text = stringResource(Res.string.about_resources_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = stringResource(Res.string.about_disclaimer),
            text = stringResource(Res.string.about_disclaimer_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun AboutExpanded(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize()
            .padding(15.dp, bottom = 60.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        TitleAndParagraph(
            title = stringResource(Res.string.about_app),
            text = stringResource(Res.string.about_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = stringResource(Res.string.about_resources),
            text = stringResource(Res.string.about_resources_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = stringResource(Res.string.about_disclaimer),
            text = stringResource(Res.string.about_disclaimer_text),
            bold = true,
            modifier = Modifier.weight(1f)
        )
    }
}