package com.data.finalproject.UnitRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.data.finalproject.R
import com.data.finalproject.databinding.ActivityUnitsInfoBinding
import java.util.Locale

class UnitsInfoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUnitsInfoBinding
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnitsInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.unitname.text = intent.getStringExtra("unitName")
        binding.unitMeaning.text = intent.getStringExtra("unitMeaning")
        binding.whereToUseKorean.text = intent.getStringExtra("whereToUseKorean")
        binding.englishWhereToUse.text = intent.getStringExtra("whereToUseEnglish")
        binding.example.text = intent.getStringExtra("example")

        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // TTS engine successfully initialized
                val result = tts.setLanguage(Locale.KOREAN)

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Language not supported by TTS engine
                    Toast.makeText(this, "Language not supported", Toast.LENGTH_SHORT).show()
                    tts.setSpeechRate(0.5f)
                }
            } else {
                // TTS engine initialization failed
                Toast.makeText(this, "TTS initialization failed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.unitname .setOnClickListener{
            val koreanUnits = binding.unitname.text.toString()
            tts.speak(koreanUnits, TextToSpeech.QUEUE_FLUSH, null, null)
            tts.setSpeechRate(0.5f)
        }
        binding.whereToUseKorean .setOnClickListener{
            val koreanUnits = binding.whereToUseKorean.text.toString()
            tts.speak(koreanUnits, TextToSpeech.QUEUE_FLUSH, null, null)
            tts.setSpeechRate(0.5f)
        }
        binding.example .setOnClickListener{
            val koreanUnits = binding.example.text.toString()
            tts.speak(koreanUnits, TextToSpeech.QUEUE_FLUSH, null, null)
            tts.setSpeechRate(0.5f)
        }


    }
}