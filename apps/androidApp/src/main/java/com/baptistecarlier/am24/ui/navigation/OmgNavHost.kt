package com.baptistecarlier.am24.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.baptistecarlier.am24.ui.feature.detail.screen.detailScreen
import com.baptistecarlier.am24.ui.feature.list.screen.listScreen

@Composable
internal fun OmgNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        listScreen(route = "list") { navController.navigate("detail/$it") }
        detailScreen(route = "detail/{id}") { navController.navigateUp() }
    }
}

