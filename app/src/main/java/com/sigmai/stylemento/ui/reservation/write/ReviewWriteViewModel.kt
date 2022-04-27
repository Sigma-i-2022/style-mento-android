package com.sigmai.stylemento.ui.reservation.write

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.repository.review.ReviewRepositoryImpl
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ReviewWriteViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var reviewRepository : ReviewRepositoryImpl

    private val startMale = SingleLiveEvent<Any>()
    private val startFemale = SingleLiveEvent<Any>()
    private var _gender = MutableLiveData<Int>(-1)
    val gender : LiveData<Int> get() = _gender

    private var _star = MutableLiveData<Int>(0)
    val star : LiveData<Int> get() = _star

    fun onMaleClick(){
        _gender.postValue(0)
        startMale.call()
    }
    fun onFemaleClick(){
        _gender.postValue(1)
        startFemale.call()
    }
    fun setStar(rating : Int){
        _star.postValue(rating)
    }
    val height = MutableLiveData<Float>(0f)
    val weight = MutableLiveData<Float>(0f)
    val content = MutableLiveData<String>("")

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()
    fun onBackClick(){
        startBack.call()
    }
    fun onNextClick(){
        startNext.call()
    }

    fun postReview() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                reviewRepository.postReview(0, "", "", "", "",
                    _star.value!!, if(_gender.value!! == 0) "MALE" else "FEMALE", height.value.toString(), weight.value.toString(), content.value!!)

            }
        }
    }

    private var _isAllSelected = MutableLiveData<Boolean>(false)
    private var _isFirstSelected = MutableLiveData<Boolean>(false)
    private var _isSecondSelected = MutableLiveData<Boolean>(false)
    val isAllSelected : LiveData<Boolean> get() = _isAllSelected
    val isFirstSelected : LiveData<Boolean> get() = _isFirstSelected
    val isSecondSelected : LiveData<Boolean> get() = _isSecondSelected

    fun onAllClick(){
        if(_isAllSelected.value!!){
            _isFirstSelected.value = false
            _isSecondSelected.value = false
        }
        else{
            _isFirstSelected.value = true
            _isSecondSelected.value = true
        }
        _isAllSelected.value = !_isAllSelected.value!!
    }
    fun onFirstClick(){
        _isAllSelected.value = !_isFirstSelected.value!! && _isSecondSelected.value!!
        _isFirstSelected.value = !_isFirstSelected.value!!
    }
    fun onSecondClick(){
        _isAllSelected.value = !_isSecondSelected.value!! && _isFirstSelected.value!!
        _isSecondSelected.value = !_isSecondSelected.value!!
    }
}