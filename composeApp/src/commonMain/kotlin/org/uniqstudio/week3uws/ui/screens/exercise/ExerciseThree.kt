package org.uniqstudio.week3uws.ui.screens.exercise

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.uniqstudio.week3uws.ui.screens.premade.TopBar
import org.uniqstudio.week3uws.ui.screens.premade.UserInputShellCompact
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.uniq_studio_logo

@Composable
fun ExerciseThree(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
){
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(
            image = Res.drawable.uniq_studio_logo,
            text = "Exercise Three",
            onClickBack = onClickBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            UserInputShellCompact(
                image = Res.drawable.uniq_studio_logo,
                title = "If-Else-If Ladder and When Statement in Kotlin",
                description = "Practice using the if-else-if ladder and the when statement for more complex decision-making.",
                infoText = "Exercise Three",
                composableContent = {
                },
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        }
    }
}