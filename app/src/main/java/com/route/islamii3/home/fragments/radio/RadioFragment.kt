package com.route.islamii3.home.fragments.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamii3.databinding.RadioFragmentBinding

class RadioFragment: Fragment() {
        lateinit var binding: RadioFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RadioFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}