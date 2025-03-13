package com.route.islamii3.home.fragments.tasbeeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamii3.R
import com.route.islamii3.databinding.TasbeehFragmentBinding

class TasbeehFragment: Fragment() {
        var counter = 0
        var currentIndex = 0
        lateinit var azkarList: MutableList<String>
        lateinit var binding: TasbeehFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TasbeehFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.tvZekr.text = azkarList[0]
        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.ivSebhaBody.setOnClickListener{
            binding.ivSebhaBody.rotation = (360/33).toFloat()

            if (counter < 33){
                counter++
            }else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size-1) ++currentIndex else 0
                binding.tvZekr.text = azkarList[currentIndex]
            }
            binding.tvTasbeehCounter.text = counter.toString()
        }
    }
}