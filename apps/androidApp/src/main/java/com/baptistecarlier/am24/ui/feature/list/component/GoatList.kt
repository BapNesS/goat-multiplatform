package com.baptistecarlier.am24.ui.feature.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.ui.common.component.LoadingView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoatList(state: List<GoatTeaser>?, goGoat: (id: String) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("List") }) }

    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        if (state != null) {
            LazyVerticalGrid(
                modifier = modifier.fillMaxSize(),
                columns = GridCells.Adaptive(120.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(state) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { goGoat(it.id) }) {
                        Column {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                contentScale = ContentScale.Crop,
                                model = it.url,
                                contentDescription = null
                            )
                            Column(modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(
                                    text = it.name,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Text(
                                    style = MaterialTheme.typography.labelSmall,
                                    text = "${it.age} mois",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                        }
                    }
                }
            }
        } else {
            LoadingView(modifier)
        }

    }
}
