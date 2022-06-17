package com.example.landapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.landapp.R
import com.example.landapp.datas.Room

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Room>): ArrayAdapter<Room>(mContext, resId, mList) {

//    mContext를 기반으로 inflater 만들거임
        val inflater = LayoutInflater.from(mContext)

//    상속 받은 클래스의 함수를 수정하는 것
//    리스트에 뿌려주는 건 맞지만 내가 원하는 Room_list_item의 모양으로 뿌려주고 싶어서 바꾸는 거임
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

//    실제 데이터까지 다 끝낸 후 row를 결과값으로 return하기 전에 할 작업을 작성

        val roomData = mList[position]

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

//    원래 String인 address를 다른 것과 결합시키기 위해서 ""를 사용 -> ""안에서는 ${}를 해야 추가 기능 사용 가능
//    getFormattedFloor은 Room 클래스에 있는 함수 -> 위에 RoomAdapter은 ArrayAdaper을 물려받으면서 Room을 대입했기 때문에 다른 곳에서도 기능 사용이 가능한 것
        addressAndFloorTxt.text = "${roomData.address}, ${roomData.getFormattedFloor()}"
        descriptionTxt.text = roomData.description
        priceTxt.text = roomData.getFormattedPrice()


        return row

    }
}