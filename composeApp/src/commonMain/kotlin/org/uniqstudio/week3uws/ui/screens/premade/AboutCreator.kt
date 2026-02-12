package org.uniqstudio.week3uws.ui.screens.premade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.uniqstudio.week3uws.ui.theme.WindowSizeClass
import org.uniqstudio.week3uws.ui.theme.getWindowSizeClass
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.about_creator_description
import uws_mobile_week3.composeapp.generated.resources.about_creator_email
import uws_mobile_week3.composeapp.generated.resources.about_creator_name
import uws_mobile_week3.composeapp.generated.resources.about_creator_number
import uws_mobile_week3.composeapp.generated.resources.about_creator_social
import uws_mobile_week3.composeapp.generated.resources.creator_profile
import uws_mobile_week3.composeapp.generated.resources.mail
import uws_mobile_week3.composeapp.generated.resources.phone
import uws_mobile_week3.composeapp.generated.resources.settings
import uws_mobile_week3.composeapp.generated.resources.share_1
import uws_mobile_week3.composeapp.generated.resources.uniq_studio_logo

@Composable
fun AboutCreatorScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
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
                AboutCreatorCompact(modifier = Modifier.padding(innerpadding))
            }

            WindowSizeClass.Medium -> {
                AboutCreatorCompact(modifier = Modifier.padding(innerpadding))
            }

            WindowSizeClass.Expanded -> {
                AboutCreatorExpanded(modifier = Modifier.padding(innerpadding))
            }
        }

    }
}

@Composable
fun AboutCreatorCompact(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 150.dp)
                .fillMaxSize()
        ) {
            ImageTitleAndDescriptionColumn(
                image = Res.drawable.creator_profile,
                title = stringResource(Res.string.about_creator_name),
                description = stringResource(Res.string.about_creator_description)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            CreatorSocials()
        }
    }
}

@Composable
fun AboutCreatorExpanded(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).fillMaxSize()
        ) {
            ImageTitleAndDescriptionColumn(
                image = Res.drawable.creator_profile,
                title = stringResource(Res.string.about_creator_name),
                description = stringResource(Res.string.about_creator_description),
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).fillMaxSize()
        ) {
            CreatorSocials()
        }
    }
}

@Composable
fun CreatorSocials() {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        IconInlineText(
            icon = Res.drawable.phone,
            text = stringResource(Res.string.about_creator_number)
        )
        IconInlineText(
            icon = Res.drawable.mail,
            text = stringResource(Res.string.about_creator_email)
        )
        IconInlineText(
            icon = Res.drawable.share_1,
            text = stringResource(Res.string.about_creator_social)
        )
    }
}
