package com.example.fragmenttest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.fragment.NewInstanceFragment
import com.example.fragmenttest.fragment.NoEmptyPrimaryConstructorFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, NoEmptyPrimaryConstructorFragment(text = "Test"))
            // add(R.id.fragment_container, NewInstanceFragment.newInstance(text = "Test"))
        }.commit()
    }
}