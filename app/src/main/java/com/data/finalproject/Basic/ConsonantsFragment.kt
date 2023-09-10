package com.data.finalproject.Basic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentConsonantsBinding
import java.util.Locale


class ConsonantsFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentConsonantsBinding
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConsonantsBinding.inflate(inflater, container, false)
        val view = binding.root

        //basic consonants
        binding.ga.setOnClickListener { speakOut(getString(R.string.ga)) }
        binding.ga2.setOnClickListener { speakOut(getString(R.string.ga)) }
        binding.na.setOnClickListener { speakOut(getString(R.string.na)) }
        binding.na2.setOnClickListener { speakOut(getString(R.string.na)) }
        binding.da.setOnClickListener { speakOut(getString(R.string.da)) }
        binding.da2.setOnClickListener { speakOut(getString(R.string.da)) }
        binding.ra.setOnClickListener { speakOut(getString(R.string.ra)) }
        binding.ra2.setOnClickListener { speakOut(getString(R.string.ra)) }
        binding.ma.setOnClickListener { speakOut(getString(R.string.ma)) }
        binding.ma2.setOnClickListener { speakOut(getString(R.string.ma)) }
        binding.ba.setOnClickListener { speakOut(getString(R.string.ba)) }
        binding.ba2.setOnClickListener { speakOut(getString(R.string.ba)) }
        binding.sa.setOnClickListener { speakOut(getString(R.string.sa)) }
        binding.sa2.setOnClickListener { speakOut(getString(R.string.sa)) }
        binding.ng.setOnClickListener { speakOut(getString(R.string.ng)) }
        binding.ng2.setOnClickListener { speakOut(getString(R.string.ng)) }
        binding.ja.setOnClickListener { speakOut(getString(R.string.ja)) }
        binding.ja2.setOnClickListener { speakOut(getString(R.string.ja)) }
        binding.cha.setOnClickListener { speakOut(getString(R.string.cha)) }
        binding.cha2.setOnClickListener { speakOut(getString(R.string.cha)) }
        binding.ka.setOnClickListener { speakOut(getString(R.string.ka)) }
        binding.ka2.setOnClickListener { speakOut(getString(R.string.ka)) }
        binding.ta.setOnClickListener { speakOut(getString(R.string.ta)) }
        binding.ta2.setOnClickListener { speakOut(getString(R.string.ta)) }
        binding.pa.setOnClickListener { speakOut(getString(R.string.pa)) }
        binding.pa2.setOnClickListener { speakOut(getString(R.string.pa)) }
        binding.ha.setOnClickListener { speakOut(getString(R.string.ha)) }

        //double consonants
        binding.ggkk.setOnClickListener { speakOut(getString(R.string.ggkk)) }
        binding.ggkk2.setOnClickListener { speakOut(getString(R.string.ggkk)) }
        binding.ddtt.setOnClickListener { speakOut(getString(R.string.ddtt)) }
        binding.ddtt2.setOnClickListener { speakOut(getString(R.string.ddtt)) }
        binding.bbpp.setOnClickListener { speakOut(getString(R.string.bbpp)) }
        binding.bbpp2.setOnClickListener { speakOut(getString(R.string.bbpp)) }
        binding.ss.setOnClickListener { speakOut(getString(R.string.ss)) }
        binding.ss2.setOnClickListener { speakOut(getString(R.string.ss)) }
        binding.jj.setOnClickListener { speakOut(getString(R.string.jj)) }
        binding.jj2.setOnClickListener { speakOut(getString(R.string.jj)) }

        textToSpeech = TextToSpeech(requireContext(), this)

        val voice = Voice("en-us-x-sfg#female_2-local", Locale.KOREAN, 400, 200, true, null)
        textToSpeech.voice = voice

        return view
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Set the language you want to use (you can change this as needed)
            val result = textToSpeech.setLanguage(Locale.KOREAN)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language data is missing or the language is not supported
                // Handle this situation if needed
            }
        }
    }

    private fun speakOut(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        // Don't forget to release TextToSpeech resources when you're done
        if (textToSpeech.isSpeaking) {
            textToSpeech.stop()
        }
        textToSpeech.shutdown()
        super.onDestroy()
    }

}