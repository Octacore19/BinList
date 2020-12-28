package com.octacoresoftwares.binlist.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.octacoresoftwares.binlist.BR
import com.octacoresoftwares.domain.model.BinResponse
import com.octacoresoftwares.domain.repository.IBinRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repo: IBinRepository) : ObservableViewModel() {

    private val _cardDetails = MutableLiveData<BinResponse>()
    val cardDetails: LiveData<BinResponse> = _cardDetails

    private val _cardVisibility = MutableLiveData(false)
    val cardVisibility: LiveData<Boolean> = _cardVisibility

    @get:Bindable
    var cardNumber = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.cardNumber)
            if (field.isNotEmpty() && field.count() > 4) {
                fetchCardDetails(field)
            } else {
                _cardVisibility.value = false
            }
        }

    private fun fetchCardDetails(cardNumber: String) = viewModelScope.launch {
        repo.fetchCardRepository(cardNumber).collect {
            if (it.success) {
                _cardVisibility.value = it.success
                _cardDetails.value = it.data!!
            }

            if (it.hasError) {
                _cardVisibility.value = !it.hasError
            }
        }
    }
}