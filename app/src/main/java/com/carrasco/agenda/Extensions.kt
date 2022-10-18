package com.carrasco.agenda

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glide(url:String){
    Glide.with(this).load(url).into(this)
}

