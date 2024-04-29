package com.baptistecarlier.am24.ui.feature.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.baptistecarlier.am24.R
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.ui.common.component.LoadingView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoatDetailView(
    state: GoatDetail?,
    goBack: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(onClick = { goBack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = { Text(stringResource(R.string.detail_title)) })
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        if (state != null) {
            GoatDetail(modifier, state)
        } else {
            LoadingView(modifier)
        }
    }
}

@Composable
private fun GoatDetail(
    modifier: Modifier = Modifier,
    state: GoatDetail,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        GoatDetailGallery(Modifier.fillMaxWidth(), state.photoUrls)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            GoatInfos(state.temperament, "${state.age} mois")
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    style = MaterialTheme.typography.headlineMedium,
                    text = state.fullName
                )
                Text(
                    style = MaterialTheme.typography.labelLarge,
                    text = state.breed
                )
            }
        }
        GoatDesc("Description", state.description)
        GoatDesc("Alimentation", state.diet)
        SkillCard(state)
    }
}

