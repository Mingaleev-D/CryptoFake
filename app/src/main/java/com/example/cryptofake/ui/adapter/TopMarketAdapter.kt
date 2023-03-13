package com.example.cryptofake.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.cryptofake.R
import com.example.cryptofake.data.common.Constants.BASE_IMAGE_URL
import com.example.cryptofake.data.model.MarketModel
import com.example.cryptofake.databinding.TopCurrencyLayoutBinding

/**
 * @author : Mingaleev D
 * @data : 13.03.2023
 */

class TopMarketAdapter(
    var context: Context,
    val list: List<MarketModel.Data.CryptoCurrency>
) : Adapter<TopMarketAdapter.MyViewholder>() {

   inner class MyViewholder(view: View) : ViewHolder(view) {
      var binding = TopCurrencyLayoutBinding.bind(view)

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
      return MyViewholder(LayoutInflater.from(context).inflate(R.layout.top_currency_layout, parent, false))
   }

   override fun getItemCount(): Int {
      return list.size
   }

   @SuppressLint("CheckResult", "SetTextI18n")
   override fun onBindViewHolder(holder: MyViewholder, position: Int) {
      val item = list[position]

      holder.binding.topCurrencyChangeTextView.text = item.name

      Glide.with(context)
         .load("${BASE_IMAGE_URL + item.id}.png")
         .thumbnail(Glide.with(context).load(R.drawable.spinner))
         .into(holder.binding.topCurrencyImageView)

      if (item.quotes!![0].percentChange24h > 0) {

         holder.binding.topCurrencyChangeTextView.apply {
            setTextColor(context.resources.getColor(R.color.teal_200))
            text = "+${String.format("%.02f", item.quotes[0].percentChange24h)} %"
         }
      } else {

         holder.binding.topCurrencyChangeTextView.apply {
            setTextColor(context.resources.getColor(R.color.red))
            text = "${String.format("%.02f", item.quotes[0].percentChange24h)} %"
         }
      }
   }
}