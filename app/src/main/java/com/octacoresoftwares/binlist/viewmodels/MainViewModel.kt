package com.octacoresoftwares.binlist.viewmodels

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.octacoresoftwares.binlist.BR
import com.octacoresoftwares.domain.model.BaseResponse
import com.octacoresoftwares.domain.model.BinResponse
import com.octacoresoftwares.domain.repository.IBinRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repo: IBinRepository) : ObservableViewModel() {

    /*private var _cardDetails = MutableLiveData<BaseResponse<BinResponse>>()
    val cardDetails: LiveData<BaseResponse<BinResponse>> = _cardDetails*/

    @get:Bindable
    var cardNumber = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.cardNumber)
            if (field.count() > 4) {
                fetchCardDetails(field)
            }
        }

    private fun fetchCardDetails(cardNumber: String) = viewModelScope.launch {
        repo.fetchCardRepository(cardNumber).collect{
            Log.i("Model", "$it")
        }
    }
}