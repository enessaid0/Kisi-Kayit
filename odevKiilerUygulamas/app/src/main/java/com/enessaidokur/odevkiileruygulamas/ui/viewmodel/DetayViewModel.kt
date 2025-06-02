package com.enessaidokur.odevkiileruygulamas.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.enessaidokur.odevkiileruygulamas.data.repository.GorevlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetayViewModel @Inject constructor(var grepo : GorevlerRepository) : ViewModel() {
    fun guncelle(id: Int, gorev: String) =
        CoroutineScope(Dispatchers.Main).launch {
            grepo.guncelle(id, gorev)
        }

}