package com.sigmai.stylemento.ui.coordinator

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.usecase.coordinator.GetCoordinatorListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoordinatorViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var getCoordinatorListUseCase: GetCoordinatorListUseCase

    val coordinatorList = MutableLiveData<List<Coordinator>>(listOf())

    fun loadDate() {
        viewModelScope.launch {
            coordinatorList.value = getCoordinatorListUseCase()!!
        }
    }

    fun onClickCoordinatorProfile(view: View, email: String) {
        val bundle = bundleOf("email" to email)
        val navController = view.findNavController()
        navController.navigate(R.id.action_main_to_coordinator_page, bundle)
    }
}