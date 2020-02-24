package com.example.newsflowmvvm.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(context: Context, url: String) = Glide.with(context).load(url).into(this)