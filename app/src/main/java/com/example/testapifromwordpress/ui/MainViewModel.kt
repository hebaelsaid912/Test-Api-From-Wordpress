package com.example.testapifromwordpress.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapifromwordpress.pojo.Products
import com.example.testapifromwordpress.remote_data.WordpressClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel():ViewModel() {
    private val _viewState = MutableStateFlow<MainProductsState>(MainProductsState.Idle)
    val state: StateFlow<MainProductsState> get() = _viewState
   // private lateinit var productsData:Products
    private val wordpressClient: WordpressClient by lazy {
        WordpressClient()
    }
    sealed class MainProductsState {
        data class Success(val products: Products) : MainProductsState()
        data class Error(val message: String) : MainProductsState()
        object Loading : MainProductsState()
        object Idle : MainProductsState()
    }

    fun getProductData(filter:Int,basicAuth:String) {
        viewModelScope.launch {
            _viewState.value = MainProductsState.Loading

            delay(2000L)
            _viewState.value = try {
                MainProductsState.Success(getProductDataFromAPI(filter,basicAuth))
            } catch (ex: Exception) {
                MainProductsState.Error(ex.message!!)
            }
        }
    }

    private fun getProductDataFromAPI(filter: Int, basicAuth: String) :Products = runBlocking {
        wordpressClient.getProductsData(filter,basicAuth)
    }


}