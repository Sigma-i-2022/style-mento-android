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
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.global.util.SingleLiveEvent
import kotlinx.coroutines.launch

class CoordinatorPageViewModel : ViewModel() {
    val repository = DummyCoordinatorRepository()

    private val _coordinator = MutableLiveData<Coordinator>()
    val coordinator: LiveData<Coordinator> get() = _coordinator

    val isMyPage = MutableLiveData(false)
    val isExtended = MutableLiveData(false)

    val startChat = SingleLiveEvent<Any>()
    val startReserve = SingleLiveEvent<Any>()

    fun onClickInstruction(){
        isExtended.value = !(isExtended.value!!)
    }
    fun onChatClick(){
        startChat.call()
    }
    fun onReserveClick(){
        startReserve.call()
    }

    fun loadCoordinatorInfo(position : Int) {
        viewModelScope.launch {
            _coordinator.postValue(Coordinator.from( repository.getCoordinatorList()[position]))
        }
    }

    fun onClickPiece(view: View, position: Int) {
        val bundle = bundleOf("position" to position)
        val navController = view.findNavController()
        if(isMyPage.value!!) navController.navigate(R.id.action_main_to_coordinator_page_piece_scroll, bundle)
        else navController.navigate(R.id.action_coordinator_page_to_coordinator_page_piece_scroll, bundle)
    }
}