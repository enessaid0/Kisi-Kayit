package com.enessaidokur.odevkiileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.enessaidokur.odevkiileruygulamas.R
import com.enessaidokur.odevkiileruygulamas.databinding.FragmentKayitBinding
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.AnasayfaViewModel
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var  viewModel : KayitViewModel
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
    binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit ,container, false)
    binding.kayitFragment = this

   binding.kayitToolbarBaslik="Görev Kayıt"
    return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitViewModel by viewModels()
        viewModel = tempViewModel
    }
fun buttonKaydet(gorev:String){
viewModel.kaydet(gorev)
}

}