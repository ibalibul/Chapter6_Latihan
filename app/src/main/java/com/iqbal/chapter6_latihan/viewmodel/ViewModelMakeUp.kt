package com.iqbal.chapter6_latihan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbal.chapter6_latihan.model.GetResspownMakeUpItem
import com.iqbal.chapter6_latihan.network.ResfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelMakeUp @Inject constructor(var api : ResfulApi) : ViewModel(){

    lateinit var liveDataMakeUp : MutableLiveData<List<GetResspownMakeUpItem>>

    init {
        liveDataMakeUp = MutableLiveData()
    }

    fun callApiMakeUp() : MutableLiveData<List<GetResspownMakeUpItem>>{
        return  liveDataMakeUp
    }

    fun callApi() {
        api.getAllProduct()
            .enqueue(object : Callback<List<GetResspownMakeUpItem>> {
                override fun onResponse(
                    call: Call<List<GetResspownMakeUpItem>>,
                    response: Response<List<GetResspownMakeUpItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeUp.postValue(response.body())
                    }else{
                        liveDataMakeUp.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetResspownMakeUpItem>>, t: Throwable) {
                    liveDataMakeUp.postValue(null)
                }

            })
    }
}