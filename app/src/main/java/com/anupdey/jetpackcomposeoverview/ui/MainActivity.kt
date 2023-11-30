package com.anupdey.jetpackcomposeoverview.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import com.anupdey.jetpackcomposeoverview.ui.compose_way.DashboardScreen
import com.anupdey.jetpackcomposeoverview.ui.theme.JetpackComposeOverviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeOverviewTheme {
                DashboardScreen()
            }
        }

        searchAndroidRepositories()
    }

    private fun searchAndroidRepositories() {
        viewModel.searchRepositories()
    }
}