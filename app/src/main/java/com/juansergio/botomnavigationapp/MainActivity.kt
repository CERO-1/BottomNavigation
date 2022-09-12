package com.juansergio.botomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.juansergio.botomnavigationapp.databinding.ActivityMainBinding
import com.juansergio.botomnavigationapp.fragmets.Homefrag
import com.juansergio.botomnavigationapp.fragmets.NotificationFragment
import com.juansergio.botomnavigationapp.fragmets.PerfilFragment

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
private  lateinit var  botomnavigation : BottomNavigationView
    private  lateinit var  toolbar: MaterialToolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar=binding.materialToolbar
        toolbar.setTitle(R.string.app_name)

        botomnavigation=binding.botomnavigation
        changeFragment(Homefrag())


        botomnavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_home -> changeFragment(Homefrag())
                R.id.item_notification -> changeFragment(NotificationFragment())
                R.id.item_perfil -> changeFragment(PerfilFragment())
                else -> {
                    changeFragment(Homefrag())
                }
            }
            true
        }





    }
    fun changeFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val framentTrasaccion: FragmentTransaction=fragmentManager.beginTransaction()
        framentTrasaccion.replace(R.id.container, fragment)
        framentTrasaccion.commit()
    }
}