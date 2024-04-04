package com.baptistecarlier.am24.ui.feature.detail.screen

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.baptistecarlier.am24.ui.feature.detail.component.GoatDetailView
import com.baptistecarlier.am24.ui.navigation.enterTransition
import com.baptistecarlier.am24.ui.navigation.popExitTransition
import org.koin.androidx.compose.koinViewModel


internal fun NavGraphBuilder.detailScreen(
    route: String,
    goBack: () -> Unit
) {
    composable(
        route = route,
        enterTransition = enterTransition,
        popExitTransition = popExitTransition,
        popEnterTransition = null,
    ) {
        val viewModel: DetailVM = koinViewModel()
        val state = viewModel.state.collectAsState().value
        GoatDetailView(state, goBack)
    }
}


