package inc.genesis.retrofit_mvvm_kotlin.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import inc.genesis.retrofit_mvvm_kotlin.API.QuotesService
import inc.genesis.retrofit_mvvm_kotlin.Model.QuotesList

class QuotesRepository(private val quoteService: QuotesService) {


    private val quotesLiveData= MutableLiveData<QuotesList>()

    val quotes : LiveData<QuotesList>
    get() = quotesLiveData

    suspend fun getQuotes(page:Int){
        val result=quoteService.getQuotes(page)
        if(result?.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }

}