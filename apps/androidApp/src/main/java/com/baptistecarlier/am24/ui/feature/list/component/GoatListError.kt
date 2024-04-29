package com.baptistecarlier.am24.ui.feature.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baptistecarlier.am24.R
import com.baptistecarlier.am24.ui.theme.OmgTheme

@Composable
internal fun GoatListError(modifier: Modifier = Modifier, onRetry: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier.wrapContentWidth(),
                style = MaterialTheme.typography.headlineMedium,
                text = stringResource(R.string.list_error_title)
            )
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = stringResource(R.string.list_error_description)
            )
            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                onClick = onRetry
            ) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Preview(widthDp = 740)
@Composable
private fun Preview() {
    OmgTheme {
        GoatListError { }
    }
}