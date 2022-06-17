package com.example.landapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.landapp.adapters.RoomAdapter
import com.example.landapp.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    맴버변수 만들 장소(클래스의 정보 표현), 보통 맴버변수를 뜻하는 m을 앞에 붙여서 변수 이름 만듦

    val mRoomList = ArrayList<Room>()

//    밑의 부동산 데이터 다 입력하고 그 후에 값을 입력할 거기 때문에 lateinit var 사용
//    RoomAdapter의 형식을 가진 변수이다
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        위의 맴버변수에 Room클래스 형식으로 데이터 저장
//        Alt + 커서이동 -> 세로로 여러 칸 동시에 수정 가능
        mRoomList.add( Room( 7500, "서울시 동대문구", 8, "서울시 동대문구의 8층 7500만원 방 입니다." ) )
        mRoomList.add( Room( 24500, "서울시 서대문구", 0, "서울시 서대문구의 반지하 2억 4500만원 방 입니다." ) )
        mRoomList.add( Room( 8500, "서울시 동작구", 0, "서울시 동작구의 반지하 8500만원 방 입니다." ) )
        mRoomList.add( Room( 4500, "서울시 은평구", -2, "서울시 은평구의 지하 2층 4500만원 방 입니다." ) )
        mRoomList.add( Room( 182500, "서울시 중랑구", 5, "서울시 중랑구의 5층 1억 18억 2500만원 방 입니다." ) )
        mRoomList.add( Room( 235000, "서울시 도봉구", 7, "서울시 도봉구의 7층 1억 23억 5000만원 방 입니다." ) )
        mRoomList.add( Room( 24000, "서울시 강남구", 19, "서울시 강남구의 19층 2억 4000만원 방 입니다." ) )
        mRoomList.add( Room( 3700, "서울시 서초구", -1, "서울시 서초구의 지하 1층 3700만원 방 입니다." ) )

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter

    }
}