package com.example.landapp.datas

import java.text.NumberFormat
import java.util.*

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String) {

//    클래스 안에 함수 만들기

    fun getFormattedFloor() : String {
        if (this.floor >= 1) {
            return "${this.floor}층"
        }

        else if(this.floor == 0) {
            return "반지하"
        }

        else {
            return "지하 ${-this.floor}"
        }

    }

//    함수 안에 있는 변수는 함수 안에서만 쓸 수 있음
    fun getFormattedPrice() : String {
        if (this.price >= 10000) {
            val uk = this.price/10000 // 정수와 정수의 나눗셈은 몫만 나온다. 결과도 정수만 나와야하기 때문
            val rest = this.price % 10000 // %는 나머지를 구하는 것

//            stackoverflow -> 코틀린 커뮤니티 -> 모르는 거 있으면 찾아서 쓰기
//            구글 검색하면 꽤나 좋음, 한글 블로그 그런 곳에서도 하면 좋음
            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}만원"
        }

        else {
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}만원"
        }
    }

}