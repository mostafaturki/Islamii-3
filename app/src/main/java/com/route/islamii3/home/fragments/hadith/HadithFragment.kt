package com.route.islamii3.home.fragments.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamii3.databinding.HadithFragmentBinding

class HadithFragment: Fragment() {
        lateinit var binding: HadithFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HadithFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}