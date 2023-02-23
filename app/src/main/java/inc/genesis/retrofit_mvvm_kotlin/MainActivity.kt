package inc.genesis.retrofit_mvvm_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import inc.genesis.retrofit_mvvm_kotlin.API.QuotesService
import inc.genesis.retrofit_mvvm_kotlin.API.RetrofitHelper
import inc.genesis.retrofit_mvvm_kotlin.Repository.QuotesRepository
import inc.genesis.retrofit_mvvm_kotlin.ViewModel.MainViewModel
import inc.genesis.retrofit_mvvm_kotlin.ViewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val quotesService=RetrofitHelper.getInstance().create(QuotesService::class.java)
        val repository=QuotesRepository(quotesService)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("genesis",it.results.toString())
        })

    }
}