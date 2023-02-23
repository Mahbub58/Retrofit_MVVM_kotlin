package inc.genesis.retrofit_mvvm_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import inc.genesis.retrofit_mvvm_kotlin.Repository.QuotesRepository

class MainViewModelFactory(private val repository: QuotesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}