package com.anupdey.jetpackcomposeoverview.ui.compose_way

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.anupdey.jetpackcomposeoverview.ui.compose_way.nav.Screen
import com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets.ToolbarWidget
import com.anupdey.jetpackcomposeoverview.ui.theme.JetpackComposeOverviewTheme
import com.anupdey.jetpackcomposeoverview.ui.xml_way.RepoSearchActivity

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    JetpackComposeOverviewTheme {
        //DashboardScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ToolbarWidget(showBackBtn = false, onNavClicked = {
                navController.popBackStack()
            })
        },
        content = { padding ->
            MenuWidget(navController = navController, padding = padding)
        }
    )
}

@Composable
private fun MenuWidget(
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    val currentContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                goToRepoSearch(currentContext)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 30.dp, vertical = 5.dp),
        ) {
            Text(text = "XML Way ➤")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(route = Screen.RepoList.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 30.dp, vertical = 5.dp),
        ) {
            Text(text = "Compose Way ➤")
        }
    }
}

private fun goToRepoSearch(context: Context) {
    Intent(context, RepoSearchActivity::class.java).also {
        context.startActivity(it)
    }
}