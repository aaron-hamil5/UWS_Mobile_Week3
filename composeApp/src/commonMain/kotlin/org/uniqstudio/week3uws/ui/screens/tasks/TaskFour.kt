package org.uniqstudio.week3uws.ui.screens.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.uniqstudio.week3uws.ui.screens.premade.TextForUI
import org.uniqstudio.week3uws.ui.screens.premade.TopBar
import org.uniqstudio.week3uws.ui.screens.premade.UserInputShellCompact
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.uniq_studio_logo

@Composable
fun TaskFour(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
){
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(
            image = Res.drawable.uniq_studio_logo,
            text = "Task Four",
            onClickBack = onClickBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            UserInputShellCompact(
                image = Res.drawable.uniq_studio_logo,
                title = "For Loop in Kotlin",
                description = "Learn to use the for loop to iterate over a range of numbers.",
                infoText = "Task Four",
                composableContent = {
                    for (i in 1..5){
                        TextForUI(
                            text = "Iteration $i"
                        )
                    }
                },
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        }
    }
}