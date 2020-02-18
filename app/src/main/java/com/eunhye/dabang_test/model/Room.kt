package com.eunhye.dabang_test.model


data class Room(
    var desc: String? = "",
    var is_check: Boolean? = false,
    var price_title: String? = "",
    var room_type: Int? = 0,
    var selling_type: Int? = 0,
    var img_url : String? = "",
    var hash_tags: List<String>
){
    fun getRoomTypeName(): String {
        return when (room_type) {
            0 -> "원룸"
            1 -> "투쓰리룸"
            2 -> "오피스텔"
            3 -> "아파트"
            else -> "원룸"
        }
    }

    fun getSellingTypeName(): String {
        return when (room_type) {
            0 -> "월세"
            1 -> "전세"
            2 -> "매매"
            else -> "월세"
        }
    }
}