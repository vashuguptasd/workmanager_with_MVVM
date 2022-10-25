package com.example.workmanagertestapplication.firstFragment

import androidx.lifecycle.*
import com.example.workmanagertestapplication.database.MyRepo
import com.example.workmanagertestapplication.database.QuoteTable
import kotlinx.coroutines.launch

class MyViewModel(private val myRepository: MyRepo) : ViewModel() {

    private val mQuote = MutableLiveData<QuoteTable>()
    val quote : LiveData<QuoteTable> = mQuote

    fun refreshDataFromInternet(){
        viewModelScope.launch {
            myRepository.refreshQuote()
        }
    }

    companion object {
        fun provideFactory(
            myRepository: MyRepo
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory() {
                override fun <T : ViewModel?> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    return MyViewModel(myRepository) as T
                }
            }
    }
}
