package com.example.retrofit.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.api.RetrofitClient
import com.example.retrofit.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        viewModelScope.launch{
            try{
                _posts.value = RetrofitClient.instance.getPosts()
            }catch (e: Exception){
                Log.e("Error", e.message?:"Error desconocido")
            }

        }
    }
}