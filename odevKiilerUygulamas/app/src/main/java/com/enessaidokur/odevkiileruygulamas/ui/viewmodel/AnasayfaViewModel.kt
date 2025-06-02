package com.enessaidokur.odevkiileruygulamas.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enessaidokur.odevkiileruygulamas.data.entity.ToDos
import com.enessaidokur.odevkiileruygulamas.data.repository.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class AnasayfaViewModel @Inject constructor(var grepo : GorevlerRepository): ViewModel() {

    var gorevlerListesi = MutableLiveData<List<ToDos>>()

    init {
        gorevleriYukle()
    }

    fun sil(gorev_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            grepo.sil(gorev_id)
            gorevleriYukle()
        }
    }

    fun gorevleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value = grepo.gorevleriYukle()
        }
    }

    fun ara(aramakelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value = grepo.ara(aramakelimesi)
        }
    }
}