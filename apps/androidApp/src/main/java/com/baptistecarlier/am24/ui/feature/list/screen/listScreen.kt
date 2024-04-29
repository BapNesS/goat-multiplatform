package com.baptistecarlier.am24.ui.feature.list.screen

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.baptistecarlier.am24.ui.feature.list.component.GoatList
import com.baptistecarlier.am24.ui.navigation.enterTransition
import com.baptistecarlier.am24.ui.navigation.popExitTransition
import org.koin.androidx.compose.koinViewModel


internal fun NavGraphBuilder.listScreen(
    route: String,
    goGoat: (id: String) -> Unit = { }
) {
    composable(
        route = route,
        enterTransition = enterTransition,
        popExitTransition = popExitTransition,
        popEnterTransition = null,
    ) {
        val viewModel: ListVM = koinViewModel()
        val state = viewModel.state.collectAsState().value
        GoatList(state, viewModel::onListModeChanged, viewModel::onRetry, goGoat)
    }
}


