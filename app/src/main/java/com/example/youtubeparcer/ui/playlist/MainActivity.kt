package com.example.youtubeparcer.ui.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeparcer.R
import com.example.youtubeparcer.adapter.PlaylistAdapter
import com.example.youtubeparcer.model.PlaylistModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val data = mutableListOf<String>()
    private var adapter : PlaylistAdapter? = null
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initAdapter()
        fetchPlaylist()
    }



    private fun initAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlaylistAdapter()
        recyclerView.adapter = adapter

    }



    private fun fetchPlaylist(){

        val data = viewModel?.getPlaylistData()
        data?.observe(this, Observer<PlaylistModel>{
            val model: PlaylistModel? = data.value
            when{
                model != null ->{
                    updateAdapterData(model)
                }
            }
        })
    }

    fun updateAdapterData(list: PlaylistModel?){
        val data = list?.items
        adapter?.updateData(data)
    }
}
