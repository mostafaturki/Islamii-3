package com.route.islamii3.home.hadithContent

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islamii3.R
import com.route.islamii3.databinding.ActivityHadithContentBinding
import com.route.islamii3.home.constants.Constants
import com.route.islamii3.home.fragments.hadith.Hadith

class HadithContentActivity : AppCompatActivity() {
        lateinit var binding : ActivityHadithContentBinding
        var hadith:Hadith? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadithContentBinding
            .inflate(layoutInflater)
        setContentView(binding.root)

        readIntentExtras()
        initViews()


    }

    private fun initViews() {
        setSupportActionBar(binding.toolbarHadith)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        title =null


        binding.tvHadithTitle.text = hadith?.title
        binding.includedContentHadith.tvHadithContent.text = hadith?.content
    }

    private fun readIntentExtras() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             hadith = intent.getParcelableExtra(Constants.EXTRA_HADITH,Hadith::class.java)
        }
        else hadith = intent.getParcelableExtra(Constants.EXTRA_HADITH) as Hadith?
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}