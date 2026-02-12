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
fun TaskThree(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
){
    val mark = 85
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(
            image = Res.drawable.uniq_studio_logo,
            text = "Task Three",
            onClickBack = onClickBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            UserInputShellCompact(
                image = Res.drawable.uniq_studio_logo,
                title = "If-Else-If Ladder and When Statement in Kotlin",
                description = "Practice using the if-else-if ladder and the when statement for more complex decision-making.",
                infoText = "Task Three",
                composableContent = {
                    TextForUI(text = "The grade is:")
                    TextForUI(text = if (mark >= 90) "A" else if (mark >= 80) "B" else if (mark >= 70) "C" else if (mark >= 60) "D" else "F")
                    TextForUI(text =
                        when {
                            mark >= 90 -> "A"
                            mark >= 80 -> "B"
                            mark >= 70 -> "C"
                            mark >= 60 -> "D"
                            else -> "F"
                        }
                    )
                    TextForUI(text = "The mark is $mark")
                },
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        }
    }
}