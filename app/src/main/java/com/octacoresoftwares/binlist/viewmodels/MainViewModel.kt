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

    var isInternetAvailable = false

    var logoList: List<Int>? = null

    @get:Bindable
    var snackBarActionText = ""

    @get:Bindable
    var showSnackBar = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.showSnackBar)
        }

    @get:Bindable
    var cardNumber = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.cardNumber)
            if (field.isNotEmpty() && field.count() > 1) {
                if (isInternetAvailable) {
                    fetchCardDetails(field)
                }
                else {
                    showSnackBar = "No internet connection"
                    snackBarActionText = "Settings"
                }
            }
        }

    private fun fetchCardDetails(cardNumber: String) = viewModelScope.launch {
        repo.fetchCardRepository(cardNumber).collect {
            if (it.success) {
                _cardDetails.value = it.data!!
            }
        }
    }
}