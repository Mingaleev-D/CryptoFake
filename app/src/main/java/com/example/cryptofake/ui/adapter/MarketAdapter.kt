package com.example.cryptofake.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.cryptofake.R
import com.example.cryptofake.data.common.Constants
import com.example.cryptofake.data.model.MarketModel
import com.example.cryptofake.databinding.CurrencyItemLayoutBinding

/**
 * @author : Mingaleev D
 * @data : 21.03.2023
 */

class MarketAdapter(
    var context: Context,
    var list: List<MarketModel.Data.CryptoCurrency>
) : Adapter<MarketAdapter.MarketViewHolder>() {
   inner class MarketViewHolder(view: View) : ViewHolder(view) {
      var binding = CurrencyItemLayoutBinding.bind(view)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
      return MarketViewHolder(
          LayoutInflater.from(context).inflate(R.layout.currency_item_layout, parent, false))
   }

   override fun getItemCount(): Int {
      return list.size
   }

   override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
      val item = list[position]

      holder.binding.currencyNameTextView.text = item.name
      holder.binding.currencySymbolTextView.text = item.symbol

      Glide.with(context)
         .load("${Constants.BASE_IMAGE_URL + item.id}.png")
         .thumbnail(Glide.with(context).load(R.drawable.spinner))
         .into(holder.binding.currencyImageView)

      Glide.with(context)
         .load("${Constants.GENERATED_URL_IMAGE + item.id}.png")
         .thumbnail(Glide.with(context).load(R.drawable.spinner))
         .into(holder.binding.currencyChartImageView)

      holder.binding.currencyPriceTextView.text =
      "${String.format("$%.02f", item.quotes[0].price.toString())}"

      if (item.quotes!![0].percentChange24h > 0) {

         holder.binding.currencyChangeTextView.apply {
            setTextColor(context.resources.getColor(R.color.teal_200))
            text = "+${String.format("%.02f", item.quotes[0].percentChange24h)} %"
         }
      } else {

         holder.binding.currencyChangeTextView.apply {
            setTextColor(context.resources.getColor(R.color.red))
            text = "${String.format("%.02f", item.quotes[0].percentChange24h)} %"
         }
      }
   }
}