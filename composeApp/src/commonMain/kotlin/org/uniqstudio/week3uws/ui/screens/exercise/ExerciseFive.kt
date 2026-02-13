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
fun ExerciseFive(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit,
){
    val fruit = listOf("Apple", "Banana", "Orange")
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(
            image = Res.drawable.uniq_studio_logo,
            text = "Exercise Five",
            onClickBack = onClickBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            UserInputShellCompact(
                image = Res.drawable.uniq_studio_logo,
                title = "For-Each Loop in Kotlin",
                description = "Understand how to use the for-each loop to iterate over a collection.",
                infoText = "Exercise Five",
                composableContent = {
                    fruit.forEach {
                        TextForUI(
                            text = it.uppercase()
                        )
                    }
                },
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        }
    }
}