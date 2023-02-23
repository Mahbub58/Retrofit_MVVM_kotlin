package inc.genesis.retrofit_mvvm_kotlin.API

import inc.genesis.retrofit_mvvm_kotlin.Model.QuotesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {


    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int) : Response<QuotesList>

}