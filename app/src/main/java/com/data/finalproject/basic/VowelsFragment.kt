package com.data.finalproject.basic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.speech.tts.Voice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.data.finalproject.R

import com.data.finalproject.databinding.FragmentVowelsBinding
import java.util.Locale

class VowelsFragment : Fragment(), OnInitListener {

    private lateinit var binding: FragmentVowelsBinding
    private lateinit var textToSpeech: TextToSpeech


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVowelsBinding.inflate(inflater, container, false)
        val view = binding.root

        //basic vowels
        binding.a.setOnClickListener { speakOut(getString(R.string.a)) }
        binding.a2.setOnClickListener { speakOut(getString(R.string.a)) }
        binding.eo.setOnClickListener { speakOut(getString(R.string.eo)) }
        binding.eo2.setOnClickListener { speakOut(getString(R.string.eo)) }
        binding.ya.setOnClickListener { speakOut(getString(R.string.ya)) }
        binding.ya2.setOnClickListener { speakOut(getString(R.string.ya)) }
        binding.yeo.setOnClickListener { speakOut(getString(R.string.yeo)) }
        binding.yeo2.setOnClickListener { speakOut(getString(R.string.yeo)) }
        binding.o.setOnClickListener { speakOut(getString(R.string.o)) }
        binding.o2.setOnClickListener { speakOut(getString(R.string.o)) }
        binding.yo.setOnClickListener { speakOut(getString(R.string.yo)) }
        binding.yo2.setOnClickListener { speakOut(getString(R.string.yo)) }
        binding.u.setOnClickListener { speakOut(getString(R.string.u)) }
        binding.u2.setOnClickListener { speakOut(getString(R.string.u)) }
        binding.yu.setOnClickListener { speakOut(getString(R.string.yu)) }
        binding.yu2.setOnClickListener { speakOut(getString(R.string.yu)) }
        binding.eu.setOnClickListener { speakOut(getString(R.string.eu)) }
        binding.eu2.setOnClickListener { speakOut(getString(R.string.eu)) }
        binding.i.setOnClickListener { speakOut(getString(R.string.i)) }
        binding.i2.setOnClickListener { speakOut(getString(R.string.i)) }

        //double vowels
        binding.ae.setOnClickListener { speakOut(getString(R.string.ae)) }
        binding.ae2.setOnClickListener { speakOut(getString(R.string.ae)) }
        binding.yae.setOnClickListener { speakOut(getString(R.string.yae)) }
        binding.e.setOnClickListener { speakOut(getString(R.string.e)) }
        binding.e2.setOnClickListener { speakOut(getString(R.string.e)) }
        binding.ye.setOnClickListener { speakOut(getString(R.string.ye)) }
        binding.ye2.setOnClickListener { speakOut(getString(R.string.ye)) }
        binding.oe.setOnClickListener { speakOut(getString(R.string.oe)) }
        binding.oe2.setOnClickListener { speakOut(getString(R.string.oe)) }
        binding.wa.setOnClickListener { speakOut(getString(R.string.wa)) }
        binding.wa2.setOnClickListener { speakOut(getString(R.string.wa)) }
        binding.wae.setOnClickListener { speakOut(getString(R.string.wae)) }
        binding.wae2.setOnClickListener { speakOut(getString(R.string.wae)) }
        binding.wi.setOnClickListener { speakOut(getString(R.string.wi)) }
        binding.wi2.setOnClickListener { speakOut(getString(R.string.wi)) }
        binding.wo.setOnClickListener { speakOut(getString(R.string.wo)) }
        binding.wo2.setOnClickListener { speakOut(getString(R.string.wo)) }
        binding.we.setOnClickListener { speakOut(getString(R.string.we)) }
        binding.we2.setOnClickListener { speakOut(getString(R.string.we)) }
        binding.ui.setOnClickListener { speakOut(getString(R.string.ui)) }
        binding.ui2.setOnClickListener { speakOut(getString(R.string.ui)) }

        textToSpeech = TextToSpeech(requireContext(), this)

        val voice = Voice("en-us-x-sfg#female_2-local", Locale.KOREAN, 400, 200, true, null)
        textToSpeech.voice = voice

        return view
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {

            val result = textToSpeech.setLanguage(Locale.KOREAN)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

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