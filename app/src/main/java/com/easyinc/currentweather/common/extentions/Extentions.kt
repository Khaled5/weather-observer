package com.easyinc.currentweather.common.extentions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun <T> androidLazy(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snacks = Snackbar.make(this,message,length)
    snacks.show()
}

fun Context.bitmapDescriptorFromVector(resId: Int): BitmapDescriptor {
    val vectorDrawable = ContextCompat.getDrawable(this,resId)
    vectorDrawable?.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
    val bitmap = Bitmap.createBitmap(vectorDrawable!!.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    vectorDrawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bitmap)
}

fun Long.isExpired(): Boolean{
    val currentTime = System.currentTimeMillis()
    val diff = currentTime - this
    val seconds = diff / 1000
    val minutes = seconds / 60

    return minutes.toInt() > 60
}

fun String.convertToDate(): String{
    val toLong = this.toLong()
    val mDate = Date(toLong * 1000L)
    val dateFormat = SimpleDateFormat("EE,d MMM", Locale("ru"))
    return dateFormat.format(mDate)
}