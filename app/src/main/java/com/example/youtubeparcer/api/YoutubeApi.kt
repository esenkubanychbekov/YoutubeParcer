package com.example.youtubeparcer.api


import retrofit2.http.GET
import retrofit2.http.Query
interface YoutubeApi {

    @GET("youtube/v3/playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("channelId")channelId: String,
        @Query("maxResults")maxResults: String
    ):retrofit2.Call<com.example.youtubeparcer.model.PlaylistModel>
}