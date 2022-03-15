package com.sigmai.stylemento.ui.coordinator.coordinatorpage

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.repository.coordinator.DummyCoordinatorRepository
import com.sigmai.stylemento.di.AppConfigs
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoordinatorPageViewModel
@Inject constructor() : ViewModel() {
    @Inject
    lateinit var coordinatorRepository: DummyCoordinatorRepository
    private val getCoordinatorUserUseCase = AppConfigs.getCoordinatorUserUseCase
    private val deletePieceUseCase = AppConfigs.deletePieceUseCase

    private val _coordinator = MutableLiveData<Coordinator>()
    val coordinator: LiveData<Coordinator> get() = _coordinator

    val isMyPage = MutableLiveData(false)
    val isExtended = MutableLiveData(false)

    val startChat = SingleLiveEvent<Any>()
    val startReserve = SingleLiveEvent<Any>()
    val onEditEvent = SingleLiveEvent<Any>()

    fun onClickInstruction() {
        isExtended.value = !(isExtended.value!!)
    }

    fun onChatClick() {
        startChat.call()
    }

    fun onReserveClick() {
        startReserve.call()
    }

    fun loadCoordinatorInfo(position: Int) {
        if (position == -1 || isMyPage.value!!) {
            viewModelScope.launch {
                _coordinator.postValue(getCoordinatorUserUseCase())
            }
        } else {
            viewModelScope.launch {
                _coordinator.postValue(Coordinator.from(coordinatorRepository.getCoordinatorList()[position]))
            }
        }
    }

    fun onClickPiece(view: View, position: Int) {
        val bundle = bundleOf("position" to position)
        val navController = view.findNavController()
        if (isMyPage.value!!) navController.navigate(
            R.id.action_main_to_coordinator_page_piece_scroll,
            bundle
        )
        else navController.navigate(
            R.id.action_coordinator_page_to_coordinator_page_piece_scroll,
            bundle
        )
    }

    fun deletePiece(id: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            deletePieceUseCase(id)
            loadCoordinatorInfo(-1)
        }
    }

    fun onEditPiece(view: View, id: Long) {
        onEditEvent.call()
//        val bundle = bundleOf("id" to id)
//        val navController = view.findNavController()
//        navController.navigate(R.id.action_coordinator_page_piece_scroll_to_add_piece, bundle)
    }
}