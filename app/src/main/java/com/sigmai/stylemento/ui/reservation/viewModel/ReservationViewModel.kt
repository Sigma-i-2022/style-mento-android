package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.compose.ui.res.colorResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.repository.datasource.DummyCoordinatorDataSource
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.entity.Receipt
import com.sigmai.stylemento.domain.entity.User
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl

    val coordinatorEmail = MutableLiveData<String>("")
    val coordinatorName = MutableLiveData<String>("")
    val coordinatorUrl = MutableLiveData<String>("")
    val userEmail = MutableLiveData<String>("")
    val userName = MutableLiveData<String>("")
    val userUrl = MutableLiveData<String>("")

    fun setCoordinatorInfo(email : String, name : String, url : String){
        coordinatorEmail.postValue(email)
        coordinatorName.postValue(name)
        coordinatorUrl.postValue((url))
    }
    fun setUserInfo(email : String, name : String, url : String){
        userEmail.postValue(email)
        userName.postValue(name)
        userUrl.postValue(url)
    }
    private val _user = MutableLiveData<User>()
    //private val _receipt = MutableLiveData<Receipt>()

    val user: LiveData<User> get() = _user
    //val receipt: LiveData<Receipt> get() = _receipt

    private val _client = MutableLiveData<Client>()
    val client: LiveData<Client> get() = _client
    val paymentWay = MutableLiveData<String>("")

    fun setClient(
        clientEmail: String,
        clientId: String,
        crdiEmail: String,
        crdiId: String,
        reserveDay: String,
        reserveTimes: List<String>,
        serviceSystem: String,
        serviceType: String
    ) {
        _client.postValue(Client(clientEmail, clientId, crdiEmail, crdiId, requestText.value!!, reserveDay, reserveTimes, serviceSystem, serviceType))
    }

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()
    fun onBackClick() {
        startBack.call()
    }

    fun onNextClick() {
        startNext.call()
    }

    private var _serviceType = MutableLiveData<Int>(-1)
    private var _serviceWay = MutableLiveData<Int>(-1)
    private var _isServiceOk = MutableLiveData<Boolean>(false)

    val serviceType: LiveData<Int> get() = _serviceType
    val serviceWay: LiveData<Int> get() = _serviceWay
    val requestText = MutableLiveData<String>("")
    val isServiceOk: LiveData<Boolean> get() = _isServiceOk

    private fun checkServiceOk() {
        _isServiceOk.value = serviceType.value != -1 && serviceWay.value != -1
    }

    fun onFeedbackClick() {
        _serviceType.value = if (_serviceType.value == 0) -1 else 0
        checkServiceOk()
    }

    fun onRecommendClick() {
        _serviceType.value = if (_serviceType.value == 1) -1 else 1
        checkServiceOk()
    }

    fun onChattingClick() {
        _serviceWay.value = if (_serviceWay.value == 0) -1 else 0
        checkServiceOk()
    }

    fun onFaceToFaceClick() {
        _serviceWay.value = if (_serviceWay.value == 1) -1 else 1
        checkServiceOk()
    }

    private var _isAllSelected = MutableLiveData<Boolean>(false)
    private var _isFirstSelected = MutableLiveData<Boolean>(false)
    private var _isSecondSelected = MutableLiveData<Boolean>(false)
    val isAllSelected: LiveData<Boolean> get() = _isAllSelected
    val isFirstSelected: LiveData<Boolean> get() = _isFirstSelected
    val isSecondSelected: LiveData<Boolean> get() = _isSecondSelected

    fun onAllClick() {
        if (_isAllSelected.value!!) {
            _isFirstSelected.value = false
            _isSecondSelected.value = false
        } else {
            _isFirstSelected.value = true
            _isSecondSelected.value = true
        }
        _isAllSelected.value = !_isAllSelected.value!!
    }

    fun onFirstClick() {
        _isAllSelected.value = !_isFirstSelected.value!! && _isSecondSelected.value!!
        _isFirstSelected.value = !_isFirstSelected.value!!
    }

    fun onSecondClick() {
        _isAllSelected.value = !_isSecondSelected.value!! && _isFirstSelected.value!!
        _isSecondSelected.value = !_isSecondSelected.value!!
    }

    fun clear() {
        onCleared()
    }

    fun postReservation() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                reservationRepository.postReservationClient(_client.value!!)
            }
        }
    }
}