package com.example.cryptofake.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import androidx.viewpager2.widget.ViewPager2.VISIBLE
import com.example.cryptofake.R
import com.example.cryptofake.data.remote.ApiInterface
import com.example.cryptofake.data.remote.ApiUtilies
import com.example.cryptofake.databinding.FragmentHomeBinding
import com.example.cryptofake.ui.adapter.TopLossGainPagerAdapter
import com.example.cryptofake.ui.adapter.TopMarketAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
   private var _binding: FragmentHomeBinding? = null
   private val binding by lazy { _binding!! }

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      getTopCurrencyList()

      setTabLayout()
   }
   private fun setTabLayout() {
      val adapter = TopLossGainPagerAdapter(this)
      binding.apply {
         contentViewPager.adapter = adapter
         contentViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
               super.onPageSelected(position)
               if(position == 0){
                  binding.apply {
                     topGainIndicator.visibility = VISIBLE
                     topLoseIndicator.visibility = GONE
                  }
               }else{
                  binding.apply {
                     topGainIndicator.visibility = GONE
                     topLoseIndicator.visibility = VISIBLE
                  }
               }
            }
         })
      }
      TabLayoutMediator(binding.tabLayout, binding.contentViewPager){ tab, position ->
         var title = if(position == 0){
            "Top Gainers"
         }else{
            "Top Losers"
         }
         tab.text = title
      }.attach()
   }

   private fun getTopCurrencyList() {
      lifecycleScope.launch(Dispatchers.IO) {
         val res =
             ApiUtilies.getInstance().create(ApiInterface::class.java).getMarketData()

         withContext(Dispatchers.Main) {
            binding.topCurrencyRecyclerView.adapter =
                TopMarketAdapter(requireContext(), res.body()!!.data.cryptoCurrencyList)
         }

         Log.d("TAG", "getTopCurrencyList: ${res.body()!!.data.cryptoCurrencyList}")
      }
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}