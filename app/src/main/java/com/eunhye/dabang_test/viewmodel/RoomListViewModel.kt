package com.eunhye.dabang_test.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.eunhye.dabang_test.base.BaseViewModel
import com.eunhye.dabang_test.model.Room
import org.json.JSONObject
import org.koin.dsl.module.applicationContext

class RoomListViewModel : BaseViewModel() {

    val roomList = MutableLiveData<List<Room>>()
//    private val exchangeTickerDataSource = mainExchangeDataSource.getTickerDataSource()

//    val liveTickers = MutableLiveData<List<Ticker>>()

//    fun getAllTickers(): Disposable =
//        exchangeTickerDataSource.getAllTicker()
//
//    fun finish() {
//        exchangeTickerDataSource.finish()
//    }


    init {

//        liveRoom.value = (exchanges.toList().map {
//            application.getString(it.nameRes)
//        })
    }


}

