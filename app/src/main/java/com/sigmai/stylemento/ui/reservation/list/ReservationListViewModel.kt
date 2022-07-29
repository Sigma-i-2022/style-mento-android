package com.sigmai.stylemento.ui.reservation.list

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ReservationListViewModel @Inject constructor() : ViewModel(), ReservationListener {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl

    val commons = MutableLiveData<List<Common>>()
    val adapterPosition = MutableLiveData(0)
    val email = MutableLiveData<String>("")
    val startBack = SingleLiveEvent<Any>()
    val startInfo = SingleLiveEvent<Any>()
    val startAdapter = SingleLiveEvent<Any>()

    fun loadData(position : Int){
        viewModelScope.launch {
            val _commons = withContext(Dispatchers.IO){
                reservationRepository.getReservationCommonList(AuthenticationInfo.email.value!!, 0, 50)
            }
            commons.value = _commons
            adapterPosition.value = position
            startAdapter.call()
        }
    }

    fun onBackClick(){
        startBack.call()
    }
    fun onInfoClick(){
        startInfo.call()
    }

    override fun onReview(view: View, seq: Long, position: Int) {
        val bundle = bundleOf("seq" to seq)
        view.findNavController().navigate(R.id.action_reservation_list_page_to_write_review_page, bundle)
    }

    override fun onDelete(view: View, seq: Long, email: String) {
        val bundle = bundleOf("seq" to seq, "email" to email)
        view.findNavController().navigate(R.id.action_reservation_list_page_to_reservation_cancel_page, bundle)
    }

    override fun onSetBuy(view: View, seq: Long, email: String, position: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                reservationRepository.postReservationClientPay(email, seq)
                loadData(position)
            }
        }
    }
}