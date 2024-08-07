package org.pradip.cmp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.pradip.cmp.data.MobileItem
import org.pradip.cmp.services.ApiService

class MobileListViewModel : ViewModel() {
    private val apiService: ApiService = ApiService.create()

    private val _mobileDataState: MutableStateFlow<MobileDataState> =
        MutableStateFlow(MobileDataState.Initial)
    val mobileDataState = _mobileDataState.asStateFlow()

    fun getMobiles() {
        viewModelScope.launch(Dispatchers.Default) {
            val mobileList = apiService.getMobiles()
            _mobileDataState.value = MobileDataState.Success(mobileList)
        }
    }

    fun getMobilesFake() {
        _mobileDataState.value = MobileDataState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            try {
                delay(2000)
                val mobileList = apiService.getMobilesFake()
                // To test exception scenario uncomment below line
                // throw Exception("Custom Exception Fake Repo")
                _mobileDataState.value = MobileDataState.Success(mobileList)
            }catch (ex:Exception){
                ex.message?.let {
                    _mobileDataState.value = MobileDataState.Failure(message = it)
                }
            }
        }
    }

}

sealed class MobileDataState() {
    data object Initial : MobileDataState()
    data object Loading : MobileDataState()
    data class Success(val data: List<MobileItem>) : MobileDataState()
    data class Failure(val message: String) : MobileDataState()
}
