package com.route.islamii3.home.fragments.tasbeeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamii3.databinding.TasbeehFragmentBinding

class TasbeehFragment: Fragment() {
        lateinit var binding: TasbeehFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TasbeehFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}