package com.example.youtubeparcer.ui.detail_playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.youtubeparcer.R

class DetailPlaylistActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailPlaylistViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_playlist)
        viewModel = ViewModelProviders.of(this).get(DetailPlaylistViewModel::class.java)
    }


}
