package com.baptistecarlier.am24.ui.feature.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.ui.feature.list.component.preview.GoatTeaserViewProvider
import com.baptistecarlier.am24.ui.theme.OmgTheme

@Composable
internal fun GoatTeaserLineView(
    goatTeaser: GoatTeaser,
    goGoat: (id: String) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { goGoat(goatTeaser.id) }) {
        Row {

            AsyncImage(
                modifier = Modifier
                    .height(72.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
                model = goatTeaser.url,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = goatTeaser.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    style = MaterialTheme.typography.labelSmall,
                    text = "${goatTeaser.age} mois",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}


@Preview
@Composable
private fun Preview(
    @PreviewParameter(GoatTeaserViewProvider::class) goatTeaser: GoatTeaser
) {
    OmgTheme {
        GoatTeaserLineView(goatTeaser, {})
    }
}