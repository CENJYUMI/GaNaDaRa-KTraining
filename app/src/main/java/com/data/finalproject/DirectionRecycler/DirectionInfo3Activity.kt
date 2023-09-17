package com.data.finalproject.DirectionRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.data.finalproject.R
import com.data.finalproject.databinding.ActivityDirectionInfo3Binding

import java.util.Locale

class DirectionInfo3Activity : AppCompatActivity() {

    private lateinit var binding : ActivityDirectionInfo3Binding
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDirectionInfo3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.directionName.text = intent.getStringExtra("koreanDirection")
        binding.directionMeaning.text = intent.getStringExtra("englishDirection")
        binding.directionExample.text = intent.getStringExtra("exampleDirection")
        binding.exampleMeaning.text = intent.getStringExtra("exampleMeaning")



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

        binding.directionName .setOnClickListener{
            val koreanUnits = binding.directionName.text.toString()
            tts.speak(koreanUnits, TextToSpeech.QUEUE_FLUSH, null, null)
            tts.setSpeechRate(0.5f)
        }
        binding.directionExample.setOnClickListener{
            val koreanUnits = binding.directionExample.text.toString()
            tts.speak(koreanUnits, TextToSpeech.QUEUE_FLUSH, null, null)
            tts.setSpeechRate(0.5f)
        }

    }
}
