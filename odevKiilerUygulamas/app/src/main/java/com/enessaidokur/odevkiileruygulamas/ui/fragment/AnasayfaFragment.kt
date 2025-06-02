package com.enessaidokur.odevkiileruygulamas.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.enessaidokur.odevkiileruygulamas.R
import com.enessaidokur.odevkiileruygulamas.data.entity.ToDos
import com.enessaidokur.odevkiileruygulamas.databinding.FragmentAnasayfaBinding
import com.enessaidokur.odevkiileruygulamas.ui.adapter.GorevlerAdapter
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.AnasayfaViewModel
import com.enessaidokur.odevkiileruygulamas.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel : AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)
        binding.anaSayfaFragment = this
        binding.anaSayfaToolbarBaslik="Görevler"

        viewModel.gorevlerListesi.observe(viewLifecycleOwner){

            val gorevlerAdapter = GorevlerAdapter(requireContext(),it,viewModel)
            binding.gorevlerAdapter = gorevlerAdapter
        }





        binding.SearchView.setOnQueryTextListener(object : OnQueryTextListener{
            // arama ikonuna bastığımıda sonuç getiren yapı
            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

            // Hrf girdikçe veya sildikçe sonuç getiren
            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)
                 return true
            }


        })

        return binding.root }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.kayitGecis)
}

    override fun onResume() {
        super.onResume()
    viewModel.gorevleriYukle()
    }

}