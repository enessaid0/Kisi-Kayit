package com.enessaidokur.odevkiileruygulamas.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.enessaidokur.odevkiileruygulamas.R

fun Navigation.gecisYap(it:View,id:Int){
    findNavController(it).navigate(id)
}
fun Navigation.gecisYap(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}