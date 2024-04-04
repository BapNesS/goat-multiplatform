package com.baptistecarlier.am24.ui.feature.detail.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
internal fun SkillRow(value: Float?, label: String) {
    value?.let {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = label
                )
                Text(text = "${it * 100} %")
            }

            val animatable = remember { Animatable(0f) }
            LaunchedEffect(Unit) {
                delay(800)
                animatable.animateTo(targetValue = it, animationSpec = tween(2000))
            }

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = { animatable.value }
            )
        }
    }
}
