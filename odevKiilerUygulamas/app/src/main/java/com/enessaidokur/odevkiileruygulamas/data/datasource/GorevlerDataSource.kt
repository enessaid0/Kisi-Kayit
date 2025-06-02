package com.enessaidokur.odevkiileruygulamas.data.datasource

import android.util.Log
import com.enessaidokur.odevkiileruygulamas.data.entity.ToDos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GorevlerDataSource  {

   suspend fun kaydet(gorev:String){
        Log.e("Görev Kaydet","$gorev")
    }
    suspend fun guncelle(id:Int,gorev:String){
        Log.e("Görev Güncelle","$id-$gorev")
    }
    suspend fun sil(gorev_id : Int){
        Log.e("Kişi Sil",gorev_id.toString())
    }
    suspend fun gorevleriYukle():List<ToDos> =
        withContext(Dispatchers.IO){
            val gorevlerListesi = ArrayList<ToDos>()
            val g1 = ToDos(1,"Yemek Yap")
            val g2 = ToDos(2,"Bulaşıkları Yıka")
            val g3 = ToDos(3,"Evi Süpür")
            gorevlerListesi.add(g1)
            gorevlerListesi.add(g2)
            gorevlerListesi.add(g3)
            return@withContext gorevlerListesi
        }
    suspend fun ara(aramakelimesi:String):List<ToDos> =
        withContext(Dispatchers.IO){
            val gorevlerListesi = ArrayList<ToDos>()
            val g1 = ToDos(1,"Yemek Yap")
            gorevlerListesi.add(g1)
            return@withContext gorevlerListesi

    }

}