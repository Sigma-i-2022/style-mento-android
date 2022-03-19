package com.sigmai.stylemento.ui.reservation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ReviewWriteViewModel : ViewModel() {
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

    val startMale = SingleLiveEvent<Any>()
    val startFemale = SingleLiveEvent<Any>()
    private var _gender = MutableLiveData<Int>(-1)
    val gender : LiveData<Int> get() = _gender
    fun onMaleClick(){
        _gender.postValue(0)
        startMale.call()
    }
    fun onFemaleClick(){
        _gender.postValue(1)
        startFemale.call()
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
}