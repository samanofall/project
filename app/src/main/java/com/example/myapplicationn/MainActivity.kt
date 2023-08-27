package com.example.myapplicationn

import UserAdapter
import UserData
//import android.app.DownloadManager.Query
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var userList =ArrayList<UserData>()
    private lateinit var adapter:UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       recyclerView=findViewById(R.id.recyclerView)
       searchView=findViewById(R.id.searchView)

       recyclerView.setHasFixedSize(true)
       recyclerView.layoutManager= LinearLayoutManager(this)
        addDataToList()
        adapter=UserAdapter(userList)
        recyclerView.adapter=adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<UserData>()
            for (i in userList) {
                if (i.username.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_LONG).show()
                adapter.setFilteredList(filteredList)
            }
            else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
            userList.add(UserData("mohamed",R.drawable.u7 ))
            userList.add(UserData("ahmed",R.drawable.u8 ))
            userList.add(UserData("amr",R.drawable.u1))
            userList.add(UserData("mahmoud",R.drawable.u2 ))
            userList.add(UserData("youssef",R.drawable.u4 ))
            userList.add(UserData("omar",R.drawable.u5 ))
            userList.add(UserData("seif",R.drawable.u6 ))
        }
}