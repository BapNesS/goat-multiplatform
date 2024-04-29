package com.baptistecarlier.am24.ui.feature.list.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.ui.feature.list.screen.ListState
import kotlinx.collections.immutable.persistentListOf

private val list = persistentListOf(
    GoatTeaser(
        "1",
        "CapriSun",
        36,
        "Alpine",
        "https://bapness.github.io/goat-multiplatform/fakeApi/goat/1/media-1.webp"
    ),
    GoatTeaser(
        "1",
        "CapriSun",
        36,
        "Alpine",
        "https://bapness.github.io/goat-multiplatform/fakeApi/goat/1/media-1.webp"
    )
)

class ListStateSuccessProvider : PreviewParameterProvider<ListState.Success> {
    override val values: Sequence<ListState.Success> = sequenceOf(
        ListState.Success(
            list,
            true
        )
    )
}

class ListStateProvider : PreviewParameterProvider<ListState> {
    override val values: Sequence<ListState> = sequenceOf(
        ListState.Loading,
        ListState.Error,
        ListState.Success(
            list,
            true
        )
    )
}