package com.route.islamii3.home.fragments.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamii3.databinding.HadithFragmentBinding
import com.route.islamii3.home.adapters.HadithRecyclerAdapter

class HadithFragment : Fragment() {
    lateinit var binding: HadithFragmentBinding
    lateinit var hadithRecycler: RecyclerView
    lateinit var hadithAdapter: HadithRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HadithFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
    }

    private fun initView(view: View) {
        hadithRecycler = binding.rvHadith
        readHadith()
        hadithRecycler.adapter = hadithAdapter


    }

    private fun readHadith() {
        val hadithList: MutableList<Hadith> = mutableListOf()

        val allFileContent = requireContext().assets.open(
            "ahadeth.txt"
        ).bufferedReader().use { it.readText() }
        val separatedHadithContent = allFileContent.split("#")
        separatedHadithContent.forEach { hadith ->
            val hadithLines = hadith.trim().split("\n").toMutableList()
            val title = hadithLines[0]
            hadithLines.removeAt(0)
            val h = Hadith(
                title = title,
                content = hadithLines.joinToString("\n")
            )
            hadithList.add(h)
        }
        bindListToAdapter(hadithList)
    }

    private fun bindListToAdapter(hadithList: MutableList<Hadith>) {
        hadithAdapter = HadithRecyclerAdapter(hadithList)
    }
}