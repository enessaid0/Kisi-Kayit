package com.enessaidokur.odevkiileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.enessaidokur.odevkiileruygulamas.R
import com.enessaidokur.odevkiileruygulamas.databinding.FragmentDetayBinding
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.AnasayfaViewModel
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?, ): View? {
    binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay ,container, false)
    binding.detayFragment = this

    binding.detayToolbarBaslik = "Görev Detay"

    val bundle:DetayFragmentArgs by navArgs()
    val gelenGorev = bundle.gorev
    binding.gorevNesnesi = gelenGorev
    return binding.root}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(id:Int,gorev:String){
       viewModel.guncelle(id,gorev)
    }

}