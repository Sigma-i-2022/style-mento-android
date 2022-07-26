package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.model.Payment
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.payment.PaymentRepositoryImpl
import com.sigmai.stylemento.data.repository.reservation.ReservationRepositoryImpl
import com.sigmai.stylemento.domain.entity.User
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var reservationRepository: ReservationRepositoryImpl
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl
    @Inject
    lateinit var paymentRepository: PaymentRepositoryImpl

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

    fun requestUserInfo(email : String) {
        viewModelScope.launch {
            val client = withContext(Dispatchers.IO) {
                myPageRepository.getMyPageClient(email)
            }
            userEmail.value = client.email
            userName.value = client.userId
            userUrl.value = client.profileImgUrl
        }
    }
    private val _user = MutableLiveData<User>()
    //private val _receipt = MutableLiveData<Receipt>()

    val user: LiveData<User> get() = _user
    //val receipt: LiveData<Receipt> get() = _receipt

    private val _client = MutableLiveData<Client>()
    val client: LiveData<Client> get() = _client
    val paymentWay = MutableLiveData<String>("")

    fun setClient(
        reserveDay: String,
        reserveTimes: List<String>,
        serviceSystem: String,
        serviceType: String
    ) {
        _client.postValue(Client(userEmail.value!!, coordinatorEmail.value!!, requestText.value!!, reserveDay, reserveTimes, serviceSystem, serviceType))
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

    val paymentInfo = MutableLiveData<Payment>()
    val seq = MutableLiveData<Long>(-1)
    val endPostPayInfo = SingleLiveEvent<Any>()
    fun postPayment() {
        viewModelScope.launch {
            val seq_ = withContext(Dispatchers.IO){
                reservationRepository.postReservationClient(_client.value!!)
            }
            seq.value = seq_
            val payment = withContext(Dispatchers.IO){
                paymentRepository.postPayment(seq.value!!, if(_payType.value == 0) "CARD" else "VIRTUAL_ACCOUNT",
                    3000, client.value!!.serviceType, client.value!!.clientEmail, userName.value!!)
            }
            paymentInfo.value = payment
            endPostPayInfo.call()
        }
    }

    fun getPaymentSuccess(url: String){

    }



    private val startCard = SingleLiveEvent<Any>()
    private val startVirtual = SingleLiveEvent<Any>()
    private var _payType = MutableLiveData<Int>(-1)
    val payType : LiveData<Int> get() = _payType

    fun onCardClick(){
        _payType.postValue(0)
        startCard.call()
    }
    fun onVirtualClick(){
        _payType.postValue(1)
        startVirtual.call()
    }
}