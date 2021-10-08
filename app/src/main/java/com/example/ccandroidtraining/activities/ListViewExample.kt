package com.example.ccandroidtraining.activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ccandroidtraining.R
import com.example.ccandroidtraining.model.ListViewData

class ListViewExample : AppCompatActivity() {
    lateinit var listView: ListView
    var arrayList: ArrayList<ListViewData> = ArrayList()
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listView = findViewById(R.id.listView)
        arrayList.add(ListViewData(1, " Rahul", "9652314800"))
        arrayList.add(ListViewData(2, " Reema", "8952130147"))
        arrayList.add(ListViewData(3, " Roy", "9999900000"))
        arrayList.add(ListViewData(4, " Rekha", "6895123014"))
        arrayList.add(ListViewData(5, " Raj", "9653334800"))
        arrayList.add(ListViewData(6, " Royal", "8900130147"))
        arrayList.add(ListViewData(7, " Roshan", "9999900000"))
        arrayList.add(ListViewData(8, " Raju", "6895113014"))
        adapter = MyAdapter(this, arrayList)
        listView.adapter = adapter
    }
}
//Class MyAdapter
class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<ListViewData>) : BaseAdapter() {
    private lateinit var serialNum: TextView
    private lateinit var name: TextView
    private lateinit var contactNum: TextView
    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.item_row_list_view, parent, false)
        serialNum = convertView.findViewById(R.id.serialNumber)
        name = convertView.findViewById(R.id.studentName)
        contactNum = convertView.findViewById(R.id.mobileNum)
        serialNum.text = " " + arrayList[position].num
        name.text = arrayList[position].name
        contactNum.text = arrayList[position].mobileNumber
        return convertView
    }
}