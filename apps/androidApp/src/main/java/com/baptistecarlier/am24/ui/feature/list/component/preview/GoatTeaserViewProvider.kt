package com.baptistecarlier.am24.ui.feature.list.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser

class GoatTeaserViewProvider : PreviewParameterProvider<GoatTeaser> {

    override val values: Sequence<GoatTeaser> = sequenceOf(
        GoatTeaser(
            "1",
            "CapriSun",
            36,
            "Alpine",
            "https://bapness.github.io/goat-multiplatform/fakeApi/goat/1/media-1.webp"
        )
    )

}

