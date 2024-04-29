package com.baptistecarlier.am24.ui.feature.list.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baptistecarlier.am24.shared.domain.interactor.list.GetGoatTeaserUc
import com.baptistecarlier.am24.shared.domain.interactor.list.GetListModeUc
import com.baptistecarlier.am24.shared.domain.interactor.list.UpdateListModeUc
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListVM(
    private val getGoatTeaserUc: GetGoatTeaserUc,
    private val getListModeUc: GetListModeUc,
    private val updateListModeUc: UpdateListModeUc,
) : ViewModel() {

    private val _state = MutableStateFlow<ListState>(ListState.Loading)
    val state: StateFlow<ListState> = _state

    init {
        viewModelScope.launch {
            val listMode = getListModeUc()

            getGoatTeaserUc()
                .onSuccess { _state.value = ListState.Success(it.toImmutableList(), listMode) }
                .onFailure { _state.value = ListState.Error }
        }
    }

    fun onListModeChanged(isList: Boolean) {
        viewModelScope.launch {
            updateListModeUc(isList)
        }
    }

}

