package com.iqbal.chapter6_latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbal.chapter6_latihan.databinding.ActivityMainBinding
import com.iqbal.chapter6_latihan.view.MakeUpAdapter
import com.iqbal.chapter6_latihan.viewmodel.ViewModelMakeUp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var makeUpAdapter : MakeUpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetVmtoAdapter()

    }

    fun SetVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeUp::class.java)
        viewModel.callApi()
        viewModel.callApiMakeUp().observe(this, Observer {
            makeUpAdapter = MakeUpAdapter(it)
            if ( it != null){
                binding.rvMakeup.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rvMakeup.adapter = MakeUpAdapter(it)
            }
        })
    }
}