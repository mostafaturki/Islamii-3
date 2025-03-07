package com.route.islamii3.home.chapterContent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamii3.databinding.ActivityChapterContentBinding
import com.route.islamii3.home.adapters.VersesAdapter
import com.route.islamii3.home.constants.Constants

class ChapterContentActivity : AppCompatActivity() {
    lateinit var versesRecycler: RecyclerView
    lateinit var versesAdapter: VersesAdapter

    private lateinit var binding : ActivityChapterContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readChapter()
        initViews()

        }

    private fun initViews() {
        setSupportActionBar(binding.toolBar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true);
            setDisplayShowHomeEnabled(true);
        }
        title = null
        versesRecycler = binding.rvVerses
        versesRecycler.adapter = versesAdapter
    }


    private fun readChapter() {
        var position = intent.getIntExtra(Constants.EXTRA_CHPATER_POSITION,-1)
        binding.tvChapterTitle.text = intent.getStringExtra(Constants.EXTRA_CHPATER_TITLE)
        val assetsContent = assets
            .open("${position}.txt").bufferedReader().use { it.readText() }
        val versesList: List<String> = assetsContent.split("\n")
        versesAdapter = VersesAdapter(versesList)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}

