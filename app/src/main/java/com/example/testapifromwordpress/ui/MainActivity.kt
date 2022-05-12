package com.example.testapifromwordpress.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.testapifromwordpress.R
import kotlinx.coroutines.launch

private const val API_BASIC_AUTH_USERNAME = "ck_ee81668aa34b37b97307b6999d401024f7a90ef4"
private const val API_BASIC_AUTH_PASSWORD = "cs_09967dd7d604e88712a2ed29627b6f61c68cf7ea"
private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate: ")
        processRender()
    }

    private fun processRender() {
        Log.d(TAG,"processRender: IN ")
        lifecycleScope.launch {
            Log.d(TAG,"processRender: lifecycleScope: IN ")
            viewModel.state.collect{ data ->
                Log.d(TAG,"processRender: lifecycleScope: viewModel: IN ")
                when(data){
                   is MainViewModel.MainProductsState.Idle -> {
                       Log.d(TAG,"processRender: Idle ")
                       Log.d(TAG,"processRender: username -> $API_BASIC_AUTH_USERNAME ")
                       Log.d(TAG,"processRender: password -> $API_BASIC_AUTH_PASSWORD ")
                       val filter = -1
                       val baseString = "$API_BASIC_AUTH_USERNAME:$API_BASIC_AUTH_PASSWORD"
                       Log.d(TAG,"processRender: baseString -> $baseString ")
                       val basicAuth = "Basic " + Base64.encodeToString(baseString.toByteArray(),Base64.NO_WRAP)
                       viewModel.getProductData(filter,basicAuth)
                    }
                    is MainViewModel.MainProductsState.Success -> {
                        Log.d(TAG,"processRender: Success ")
                            Log.d(
                                TAG,
                                "processRender: attributes -> ${data.products.products?.get(0)?.images?.get(0)?.src.toString()} "
                            )
                            Log.d(
                                TAG,
                                "processRender: average_rating -> ${data.products.products?.get(0)?.average_rating} "
                            )
                    }
                    is MainViewModel.MainProductsState.Loading -> {
                        Log.d(TAG,"processRender: Loading ")
                    }
                    is MainViewModel.MainProductsState.Error -> {
                        Log.d(TAG,"processRender: Error -> ${data.message}")
                    }
                }

            }

        }
    }
}