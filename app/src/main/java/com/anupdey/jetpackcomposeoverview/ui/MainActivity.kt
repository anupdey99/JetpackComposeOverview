package com.anupdey.jetpackcomposeoverview.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.anupdey.jetpackcomposeoverview.ui.compose_way.nav.NavHostMain
import com.anupdey.jetpackcomposeoverview.ui.theme.JetpackComposeOverviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeOverviewTheme {
                SetupNavController()
            }
        }
    }

    @Composable
    private fun SetupNavController() {
        val navController = rememberNavController()
        NavHostMain(navController = navController)
    }
}