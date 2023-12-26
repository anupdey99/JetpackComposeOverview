package com.anupdey.jetpackcomposeoverview.ui.compose_way.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import com.anupdey.jetpackcomposeoverview.ui.compose_way.DashboardScreen
import com.anupdey.jetpackcomposeoverview.ui.compose_way.ListScreen
import com.anupdey.jetpackcomposeoverview.ui.compose_way.RepoDetailsScreen

const val ARG_KEY_REPO_ID = "id"

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object RepoList : Screen("repo_list")
    object RepoDetails : Screen("repo_details/{$ARG_KEY_REPO_ID}") {
        fun withId(id: Int): String {
            return this.route.replace(oldValue = "{$ARG_KEY_REPO_ID}", newValue = id.toString())
        }
    }
}

@Composable
fun NavHostMain(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController)
        }

        composable(route = Screen.RepoList.route) {
            val viewModel: MainViewModel = hiltViewModel()
            ListScreen(navController, viewModel)
        }

        composable(route = Screen.RepoDetails.route, arguments = listOf(
            navArgument(ARG_KEY_REPO_ID) {
                type = NavType.IntType
            }
        )) {

            val parentEntry = remember(it) {
                navController.getBackStackEntry(Screen.RepoList.route)
            }
            val viewModel: MainViewModel = hiltViewModel(parentEntry)
            val id = it.arguments?.getInt(ARG_KEY_REPO_ID)
            val model = viewModel.fetchByRepoId(id)
            RepoDetailsScreen(navController, model)
        }
    }
}