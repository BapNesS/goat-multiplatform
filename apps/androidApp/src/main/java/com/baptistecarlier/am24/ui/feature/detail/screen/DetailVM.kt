package com.baptistecarlier.am24.ui.feature.detail.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.am24.shared.domain.interactor.detail.GetGoatDetailUc
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailVM(
    savedStateHandle: SavedStateHandle,
    private val getGoatDetailUc: GetGoatDetailUc
) : ViewModel() {

    private val _state = MutableStateFlow<GoatDetail?>(null)
    val state: StateFlow<GoatDetail?> = _state

    init {
        val id: String? = savedStateHandle["id"]
        viewModelScope.launch {
            _state.value = getGoatDetailUc(id = id.orEmpty())
        }
    }

}