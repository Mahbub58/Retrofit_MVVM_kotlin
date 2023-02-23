package inc.genesis.retrofit_mvvm_kotlin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inc.genesis.retrofit_mvvm_kotlin.Model.QuotesList
import inc.genesis.retrofit_mvvm_kotlin.Repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository:QuotesRepository) : ViewModel(){


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes : LiveData<QuotesList>
    get() = repository.quotes




}