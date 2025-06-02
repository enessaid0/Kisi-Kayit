package com.enessaidokur.odevkiileruygulamas.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.enessaidokur.odevkiileruygulamas.R
import com.enessaidokur.odevkiileruygulamas.data.entity.ToDos
import com.enessaidokur.odevkiileruygulamas.databinding.CardTasarimBinding import com.enessaidokur.odevkiileruygulamas.ui.fragment.AnasayfaFragmentDirections
import com.enessaidokur.odevkiileruygulamas.ui.viewmodel.AnasayfaViewModel
import com.enessaidokur.odevkiileruygulamas.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class GorevlerAdapter(var mContext:Context, var gorevlerListesi:List<ToDos>,var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<GorevlerAdapter.cardTasrimTutucu>() {

    // CardTasarimBinding card_tasarim.xml in bir class ı oldu.
 inner class cardTasrimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasrimTutucu {
  val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return  cardTasrimTutucu(binding)}

    // Bu fonksiyon kartla alakalı tıklama gibi vesaire işleri yapmamızı sağlıyor.
    // Buraya kadar herşey aşağı yukarı aynı burdan sonra karta göre kodluyorsunuz
    override fun onBindViewHolder(holder: cardTasrimTutucu, position: Int) {
        val gorev = gorevlerListesi.get(position)
        val t = holder.tasarim
        t.gorevNesnesi = gorev

        t.CardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(gorev = gorev)
            Navigation.gecisYap(it,gecis)
        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${gorev.name} silinsin mi ? ",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                viewModel.sil(gorev.id)
                }
                    .show()
        }
    }

    override fun getItemCount(): Int { // kac tane item var bunu soruyor
        return gorevlerListesi.size
    }

}