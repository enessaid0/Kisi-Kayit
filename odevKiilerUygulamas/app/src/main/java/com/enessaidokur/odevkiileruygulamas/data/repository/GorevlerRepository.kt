package com.enessaidokur.odevkiileruygulamas.data.repository


import com.enessaidokur.odevkiileruygulamas.data.datasource.GorevlerDataSource
import com.enessaidokur.odevkiileruygulamas.data.entity.ToDos



class GorevlerRepository (var gds : GorevlerDataSource){
    suspend fun kaydet(gorev:String) = gds.kaydet(gorev)
    suspend fun guncelle(id:Int,gorev:String) = gds.guncelle(id,gorev)
    suspend fun sil(gorev_id : Int) = gds.sil(gorev_id)
    suspend fun  gorevleriYukle():List<ToDos> = gds.gorevleriYukle()
    suspend fun ara(aramakelimesi:String):List<ToDos> = gds.ara(aramakelimesi)
}
