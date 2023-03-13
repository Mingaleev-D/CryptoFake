package com.example.cryptofake.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.example.cryptofake.R
import com.example.cryptofake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)

      val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
      val navController = navHostFragment!!.findNavController()

      val popupMenu = PopupMenu(this, null)
      popupMenu.inflate(R.menu.btn_menu)
      binding.bottomBar.setupWithNavController(popupMenu.menu, navController)
   }
}