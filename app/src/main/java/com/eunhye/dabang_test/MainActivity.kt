package com.eunhye.dabang_test

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.eunhye.dabang_test.base.BaseActivity
import com.eunhye.dabang_test.databinding.ActivityMainBinding
import com.eunhye.dabang_test.model.Average
import com.eunhye.dabang_test.model.Room
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity
    : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    var liveRoomList : MutableList<Room> = arrayListOf()
    // [single, double, studio, apartment]
    var liveRoomTypeCheck = mutableListOf(true,true,true,true)
    var liveAverageData = Average("","", "")

    var liveSellingTypeCheck = mutableListOf(true,true,true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            view = this@MainActivity
            initRoomData()

            recyclerView.run {
                adapter = RecyclerAdapter(this@MainActivity, liveRoomList)
            }

            liveAverageData.let{
                tvName.text = it.name
                tvAverMonthlyRentFee.text = it.monthPrice
                tvAverYearlyRentFee.text = it.yearPrice
            }
        }
    }

    private fun initRoomData() {

        val assetManager = resources.assets
        val inputStream= assetManager.open("rooms.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("rooms")

        val jAverageArray = jObject.getJSONArray("average")
        liveAverageData = Gson().fromJson(jAverageArray[0].toString(),Average::class.java)

        for (i in 0 until jArray.length()) {
            jArray[i].let{
                liveRoomList.add(Gson().fromJson(it.toString(),Room::class.java))
            }
        }
    }


    fun onClickRoomOption(roomType: Int) {
        when (roomType) {
            0 -> liveRoomTypeCheck[0] = binding.cbSingle.isChecked
            1 -> liveRoomTypeCheck[1] = binding.cbDouble.isChecked
            2 -> liveRoomTypeCheck[2] = binding.cbStudio.isChecked
            3 -> liveRoomTypeCheck[3] = binding.cbApartment.isChecked
        }

        sortRoomList("room")
    }

    fun onClickSellingOption(sellingType: Int) {
        when (sellingType) {
            0 -> liveSellingTypeCheck[0] = binding.cbMontly.isChecked
            1 -> liveSellingTypeCheck[1] = binding.cbYearly.isChecked
            2 -> liveSellingTypeCheck[2] = binding.cbSale.isChecked
        }

        sortRoomList("sell")
    }

    private fun sortRoomList(sortType: String){
        var sortedList : MutableList<Room> = arrayListOf()

        when(sortType) {
            "room" -> sortedList = liveRoomList.filter {
                liveRoomTypeCheck[it.room_type!!]
            }.toMutableList()

            "sell" -> sortedList = liveRoomList.filter {
                liveSellingTypeCheck[it.selling_type!!]
            }.toMutableList()
        }

        binding.recyclerView.run{
            adapter = RecyclerAdapter(this@MainActivity, sortedList)
            adapter!!.notifyDataSetChanged()
        }
    }
}

