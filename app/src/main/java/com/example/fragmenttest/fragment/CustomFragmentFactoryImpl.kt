package com.example.fragmenttest.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class CustomFragmentFactoryImpl(
    private val text: String
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            NoEmptyPrimaryConstructorFragment::class.java.name -> {
                NoEmptyPrimaryConstructorFragment(text = text)
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}