package com.baptistecarlier.am24.ui.feature.detail.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun GoatDetailGallery(
    modifier: Modifier = Modifier,
    photoUrls: List<String>
) {
    photoUrls.takeIf { it.size > 1 }
        ?.take(2)
        ?.let { items ->
            Row(
                modifier = modifier.animateContentSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items.forEach {
                    AsyncImage(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .widthIn(max = 200.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop,
                        model = it,
                        contentDescription = null
                    )
                }
            }
        }

}
