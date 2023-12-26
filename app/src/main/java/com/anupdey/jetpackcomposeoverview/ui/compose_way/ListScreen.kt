package com.anupdey.jetpackcomposeoverview.ui.compose_way

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import com.anupdey.jetpackcomposeoverview.ui.compose_way.nav.Screen
import com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets.ItemWidget
import com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets.ToolbarWidget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController, viewModel: MainViewModel) {

    val listState by viewModel.repoListState

    Scaffold(
        topBar = {
            ToolbarWidget(showBackBtn = true, onNavClicked = {
                navController.popBackStack()
            })
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(listState.count(), /*key = {
                    listState[it].id
                }*/) {
                    val model = listState[it]
                    ItemWidget(model) {
                        navController.navigate(Screen.RepoDetails.withId(model.id))
                    }
                }
            }
        }
    )
}