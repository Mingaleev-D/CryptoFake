package com.example.cryptofake.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cryptofake.databinding.FragmentTopGainLoseBinding

class TopGainLoseFragment : Fragment() {
   private var _binding: FragmentTopGainLoseBinding? = null
   private val binding by lazy { _binding!! }

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {
      _binding = FragmentTopGainLoseBinding.inflate(inflater, container, false)
      return binding.root
   }
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}
