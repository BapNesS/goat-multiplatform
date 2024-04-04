package com.baptistecarlier.am24.ui.feature.list.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.am24.shared.domain.interactor.list.GetGoatTeaserUc
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListVM(
    private val getGoatTeaserUc: GetGoatTeaserUc
) : ViewModel() {

    private val _state = MutableStateFlow<List<GoatTeaser>?>(null)
    val state: StateFlow<List<GoatTeaser>?> = _state

    init {
        viewModelScope.launch {
            _state.value = getGoatTeaserUc()
        }
    }

}