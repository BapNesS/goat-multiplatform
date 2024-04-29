package com.baptistecarlier.am24.ui.feature.list.screen

import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import kotlinx.collections.immutable.ImmutableList

sealed interface ListState {
    data object Loading: ListState
    data object Error: ListState
    data class Success(val list: ImmutableList<GoatTeaser>, val isListMode: Boolean): ListState
}