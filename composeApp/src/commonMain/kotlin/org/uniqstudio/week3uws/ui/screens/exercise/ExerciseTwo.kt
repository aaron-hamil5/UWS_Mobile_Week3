package org.uniqstudio.week3uws.ui.screens.exercise

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
fun ExerciseTwo(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
){
    val num = 10
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(
            image = Res.drawable.uniq_studio_logo,
            text = "Exercise Two",
            onClickBack = onClickBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            UserInputShellCompact(
                image = Res.drawable.uniq_studio_logo,
                title = "If-Else Statements in Kotlin",
                description = "Understand how to use the if-else statement for decision-making.",
                infoText = "Exercise Two",
                composableContent = {
                    TextForUI(
                        text = if (num % 2 == 0) "Number is even - $num" else "Number is odd - $num"
                    )
                    TextForUI(
                        text = if (num % 5 == 0) "Number is dividable by 5 - $num" else "Number is not dividable by 5 - $num"
                    )
                },
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        }
    }
}