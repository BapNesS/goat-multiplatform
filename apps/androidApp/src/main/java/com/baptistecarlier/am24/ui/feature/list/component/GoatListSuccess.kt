package com.baptistecarlier.am24.ui.feature.list.component

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ViewList
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.baptistecarlier.am24.R
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.ui.feature.list.component.preview.ListStateSuccessProvider
import com.baptistecarlier.am24.ui.feature.list.screen.ListState
import com.baptistecarlier.am24.ui.theme.OmgTheme
import kotlinx.collections.immutable.ImmutableList

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
internal fun GoatListSuccess(
    modifier: Modifier = Modifier,
    goatTeasers: ImmutableList<GoatTeaser>,
    isListMode: Boolean,
    goListModeChanged: (isList: Boolean) -> Unit,
    goGoat: (id: String) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        val listView = rememberSaveable { mutableStateOf(isListMode) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            val (icon, labelResId) = if (listView.value) {
                Icons.AutoMirrored.Outlined.ViewList to stringResource(R.string.viewmode_list)
            } else {
                Icons.Default.GridView to stringResource(R.string.viewmode_grid)
            }
            ElevatedAssistChip(
                colors = AssistChipDefaults.elevatedAssistChipColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    leadingIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                ),
                leadingIcon = { Icon(icon, null) },
                onClick = {
                    listView.value = listView.value.not()
                    goListModeChanged(listView.value)
                },
                label = { Text(labelResId) }
            )
        }

        Crossfade(targetState = listView.value, label = "ListOrGrid") { _ ->
            val contentPadding =
                PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            val arrangement = Arrangement.spacedBy(12.dp)

            if (listView.value) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    contentPadding = contentPadding,
                    verticalArrangement = arrangement,
                ) {
                    items(goatTeasers) {
                        GoatTeaserLineView(it, goGoat)
                    }
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.weight(1f),
                    columns = GridCells.Adaptive(120.dp),
                    contentPadding = contentPadding,
                    verticalArrangement = arrangement,
                    horizontalArrangement = arrangement,
                ) {
                    items(goatTeasers) {
                        GoatTeaserCardView(it, goGoat)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(
    @PreviewParameter(ListStateSuccessProvider::class) model: ListState.Success
) {
    OmgTheme {
        GoatListSuccess(Modifier, model.list, model.isListMode, { }) {}
    }
}