package org.uniqstudio.week3uws.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseEight
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseEleven
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseFive
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseFour
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseNine
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseOne
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseSeven
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseSix
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseTen
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseThree
import org.uniqstudio.week3uws.ui.screens.exercise.ExerciseTwo
import org.uniqstudio.week3uws.ui.screens.premade.AboutCreatorScreen
import org.uniqstudio.week3uws.ui.screens.premade.AboutScreen
import org.uniqstudio.week3uws.ui.screens.premade.SettingsScreen
import org.uniqstudio.week3uws.ui.screens.premade.SmartBackground
import org.uniqstudio.week3uws.ui.screens.premade.WelcomeScreen
import org.uniqstudio.week3uws.ui.screens.premade.WideImageButtonBar
import org.uniqstudio.week3uws.ui.screens.tasks.TaskEight
import org.uniqstudio.week3uws.ui.screens.tasks.TaskEleven
import org.uniqstudio.week3uws.ui.screens.tasks.TaskFive
import org.uniqstudio.week3uws.ui.screens.tasks.TaskFour
import org.uniqstudio.week3uws.ui.screens.tasks.TaskNine
import org.uniqstudio.week3uws.ui.screens.tasks.TaskOne
import org.uniqstudio.week3uws.ui.screens.tasks.TaskSeven
import org.uniqstudio.week3uws.ui.screens.tasks.TaskSix
import org.uniqstudio.week3uws.ui.screens.tasks.TaskTen
import org.uniqstudio.week3uws.ui.screens.tasks.TaskThree
import org.uniqstudio.week3uws.ui.screens.tasks.TaskTwo
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.settings
import uws_mobile_week3.composeapp.generated.resources.uniq_studio_logo

enum class UniqAppScreens(val screen: String) {
    Welcome("Welcome"),
    Home("Home"),
    Settings("Settings"),
    AboutApp("About App"),
    AboutCreator("About Creator"),

    TaskOne("TaskOne"),
    TaskTwo("TaskTwo"),
    TaskThree("TaskThree"),
    TaskFour("TaskFour"),
    TaskFive("TaskFive"),
    TaskSix("TaskSix"),
    TaskSeven("TaskSeven"),
    TaskEight("TaskEight"),
    TaskNine("TaskNine"),
    TaskTen("TaskTen"),
    TaskEleven("TaskEleven"),

    ExerciseOne("ExerciseOne"),
    ExerciseTwo("ExerciseTwo"),
    ExerciseThree("ExerciseThree"),
    ExerciseFour("ExerciseFour"),
    ExerciseFive("ExerciseFive"),
    ExerciseSix("ExerciseSix"),
    ExerciseSeven("ExerciseSeven"),
    ExerciseEight("ExerciseEight"),
    ExerciseNine("ExerciseNine"),
    ExerciseTen("ExerciseTen"),
    ExerciseEleven("ExerciseEleven"),
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UniqApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            modifier = modifier.fillMaxSize(),
            navController = navController,
            startDestination = UniqAppScreens.Welcome.screen,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth }, // slide to right when popping
                    animationSpec = tween(durationMillis = 300)
                )
            }

        ) {
            composable(route = UniqAppScreens.Welcome.screen,) {
                SmartBackground(alpha = .2f)
                WelcomeScreen(
                    modifier = modifier.padding(10.dp),
                    onClickNext = { navController.navigate(UniqAppScreens.Home.screen) },
                    onClickSettings = { navController.navigate(UniqAppScreens.Settings.screen) }
                )
            }

            composable(route = UniqAppScreens.Settings.screen) {
                SmartBackground(image = Res.drawable.settings, icon = true)
                SettingsScreen(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickAbout = { navController.navigate(UniqAppScreens.AboutApp.screen) }
                )
            }

            composable(route = UniqAppScreens.AboutApp.screen) {
                SmartBackground()
                AboutScreen(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickAbout = { navController.navigate(UniqAppScreens.AboutCreator.screen) }
                )
            }

            composable(route = UniqAppScreens.AboutCreator.screen) {
                SmartBackground()
                AboutCreatorScreen(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() }
                )
            }

            composable(route = UniqAppScreens.Home.screen) {
                SmartBackground()
                Column {
                    WideImageButtonBar(
                        modifier = modifier.padding(5.dp),
                        image = Res.drawable.uniq_studio_logo,
                        text = "Tasks",
                        bold = false,
                        onClick = { navController.navigate(UniqAppScreens.TaskOne.screen) },
                    )
                    WideImageButtonBar(
                        modifier = modifier.padding(5.dp),
                        image = Res.drawable.uniq_studio_logo,
                        text = "Exercises",
                        bold = false,
                        onClick = { navController.navigate(UniqAppScreens.ExerciseOne.screen) },
                    )
                }
            }


            composable(route = UniqAppScreens.TaskOne.screen) {
                SmartBackground()
                TaskOne(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskTwo.screen) },

                    )
            }
            composable(route = UniqAppScreens.TaskTwo.screen) {
                SmartBackground()
                TaskTwo(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskThree.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskThree.screen) {
                SmartBackground()
                TaskThree(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskFour.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskFour.screen) {
                SmartBackground()
                TaskFour(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskFive.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskFive.screen) {
                SmartBackground()
                TaskFive(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskSix.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskSix.screen) {
                SmartBackground()
                TaskSix(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskSeven.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskSeven.screen) {
                SmartBackground()
                TaskSeven(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskEight.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskEight.screen) {
                SmartBackground()
                TaskEight(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskNine.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskNine.screen) {
                SmartBackground()
                TaskNine(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.TaskTen.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskTen.screen) {
                SmartBackground()
                TaskTen(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseEleven.screen) },
                )
            }
            composable(route = UniqAppScreens.TaskEleven.screen) {
                SmartBackground()
                TaskEleven(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.Welcome.screen) },
                )
            }

            composable(route = UniqAppScreens.ExerciseOne.screen) {
                SmartBackground()
                ExerciseOne(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseTwo.screen) },

                    )
            }
            composable(route = UniqAppScreens.ExerciseTwo.screen) {
                SmartBackground()
                ExerciseTwo(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseThree.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseThree.screen) {
                SmartBackground()
                ExerciseThree(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseFour.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseFour.screen) {
                SmartBackground()
                ExerciseFour(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseFive.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseFive.screen) {
                SmartBackground()
                ExerciseFive(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseSix.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseSix.screen) {
                SmartBackground()
                ExerciseSix(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseSeven.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseSeven.screen) {
                SmartBackground()
                ExerciseSeven(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseEight.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseEight.screen) {
                SmartBackground()
                ExerciseEight(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseNine.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseNine.screen) {
                SmartBackground()
                ExerciseNine(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseTen.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseTen.screen) {
                SmartBackground()
                ExerciseTen(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.ExerciseEleven.screen) },
                )
            }
            composable(route = UniqAppScreens.ExerciseEleven.screen) {
                SmartBackground()
                ExerciseEleven(
                    modifier = modifier.padding(5.dp),
                    onClickBack = { navController.navigateUp() },
                    onClickNext = { navController.navigate(UniqAppScreens.Welcome.screen) },
                )
            }
        }
    }
}