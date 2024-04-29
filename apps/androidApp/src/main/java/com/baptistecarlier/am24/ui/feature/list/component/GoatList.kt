package com.baptistecarlier.am24.ui.feature.list.component

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.baptistecarlier.am24.R
import com.baptistecarlier.am24.ui.common.component.LoadingView
import com.baptistecarlier.am24.ui.feature.list.component.preview.ListStateProvider
import com.baptistecarlier.am24.ui.feature.list.screen.ListState
import com.baptistecarlier.am24.ui.theme.OmgTheme

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoatList(
    state: ListState,
    onListModeChanged: (isList: Boolean) -> Unit,
    goGoat: (id: String) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.list_title)) },
                scrollBehavior = scrollBehavior
            )
        }

    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        Crossfade(targetState = state, label = "ListState") { _ ->
            when (state) {
                ListState.Error -> LoadingView(modifier)
                ListState.Loading -> LoadingView(modifier)
                is ListState.Success -> {
                    GoatListSuccess(modifier = modifier, state.list, state.isListMode, onListModeChanged, goGoat)
                }
            }
        }

    }
}

@Preview
@Composable
private fun Preview(
    @PreviewParameter(ListStateProvider::class) state: ListState
) {
    OmgTheme {
        GoatList(state, { }, { })
    }
}