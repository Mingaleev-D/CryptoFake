package com.example.cryptofake.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cryptofake.ui.fragments.TopGainLoseFragment

/**
 * @author : Mingaleev D
 * @data : 21.03.2023
 */

class TopLossGainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
   override fun getItemCount() = 2

   override fun createFragment(position: Int): Fragment {
      val fragment = TopGainLoseFragment()
      val bundle = Bundle()
      bundle.putInt("position" , position)
      fragment.arguments = bundle
      return  fragment
   }
}