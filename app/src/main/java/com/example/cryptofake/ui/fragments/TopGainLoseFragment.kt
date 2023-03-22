package com.example.cryptofake.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cryptofake.data.model.MarketModel
import com.example.cryptofake.data.remote.ApiInterface
import com.example.cryptofake.data.remote.ApiUtilies
import com.example.cryptofake.databinding.FragmentTopGainLoseBinding
import com.example.cryptofake.ui.adapter.MarketAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Collections
import java.util.stream.Collectors

class TopGainLoseFragment : Fragment() {
   private var _binding: FragmentTopGainLoseBinding? = null
   private val binding by lazy { _binding!! }

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentTopGainLoseBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      getMarketData()
   }

   private fun getMarketData() {

      val position = requireArguments().getInt("position")

      lifecycleScope.launch(Dispatchers.IO) {
         val res =
             ApiUtilies.getInstance().create(ApiInterface::class.java).getMarketData()

         if (res.body() != null) {
            withContext(Dispatchers.IO) {
               val dataItem = res.body()!!.data.cryptoCurrencyList

               Collections.sort(dataItem) { o1, o2 ->
                  (o2.quotes[0].percentChange24h.toInt())
                     .compareTo(o1.quotes[0].percentChange24h.toInt())
               }

               binding.spinKitView.visibility = GONE
               val list = ArrayList<MarketModel.Data.CryptoCurrency>()
               if (position == 0) {
                  list.clear()

                  for (i in 0..9) {
                     list.add(dataItem[i])
                  }

                  binding.topGainLoseRecyclerView.adapter = MarketAdapter(requireContext(), list)

               } else {

                  list.clear()

                  for (i in 0..9) {
                     list.add(dataItem[dataItem.size-1-i])
                  }

                  binding.topGainLoseRecyclerView.adapter = MarketAdapter(requireContext(), list)
               }
            }
         }
      }
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}
