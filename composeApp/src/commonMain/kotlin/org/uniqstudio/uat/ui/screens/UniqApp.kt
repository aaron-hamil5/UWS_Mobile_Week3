package org.uniqstudio.uat.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
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
import org.uniqstudio.uat.ui.screens.premade.AboutCreatorScreen
import org.uniqstudio.uat.ui.screens.premade.AboutScreen
import org.uniqstudio.uat.ui.screens.premade.SettingsScreen
import org.uniqstudio.uat.ui.screens.premade.SmartBackground
import org.uniqstudio.uat.ui.screens.premade.WelcomeScreen
import uniqapptemplate.composeapp.generated.resources.Res
import uniqapptemplate.composeapp.generated.resources.settings

enum class UniqAppScreens(val screen: String) {
    Welcome("Welcome"),
    Home("Home"),
    Settings("Settings"),
    AboutApp("About App"),
    AboutCreator("About Creator")
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
                    onClickNext = {
                        navController.popBackStack()
                        navController.navigate(UniqAppScreens.Home.screen) },
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
            }
        }
    }
}