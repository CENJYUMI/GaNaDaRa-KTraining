package com.data.finalproject.Basic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentConsonantsBinding
import com.data.finalproject.databinding.FragmentTimeBinding
import java.util.Locale


class TimeFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentTimeBinding
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.hour1.setOnClickListener{ speakOut(getString(R.string.hour1)) }
        binding.hour2.setOnClickListener{ speakOut(getString(R.string.hour2)) }
        binding.hour3.setOnClickListener{ speakOut(getString(R.string.hour3)) }
        binding.hour4.setOnClickListener{ speakOut(getString(R.string.hour4)) }
        binding.hour5.setOnClickListener{ speakOut(getString(R.string.hour5)) }
        binding.hour6.setOnClickListener{ speakOut(getString(R.string.hour6)) }
        binding.hour7.setOnClickListener{ speakOut(getString(R.string.hour7)) }
        binding.hour8.setOnClickListener{ speakOut(getString(R.string.hour8)) }
        binding.hour9.setOnClickListener{ speakOut(getString(R.string.hour9)) }
        binding.hour10.setOnClickListener{ speakOut(getString(R.string.hour10)) }
        binding.hour11.setOnClickListener{ speakOut(getString(R.string.hour11)) }
        binding.hour12.setOnClickListener{ speakOut(getString(R.string.hour12)) }

        binding.min5.setOnClickListener{ speakOut(getString(R.string.min5)) }
        binding.min10.setOnClickListener{ speakOut(getString(R.string.min10)) }
        binding.min15.setOnClickListener{ speakOut(getString(R.string.min15)) }
        binding.min20.setOnClickListener{ speakOut(getString(R.string.min20)) }
        binding.min25.setOnClickListener{ speakOut(getString(R.string.min25)) }
        binding.min30.setOnClickListener{ speakOut(getString(R.string.min30)) }
        binding.min35.setOnClickListener{ speakOut(getString(R.string.min35)) }
        binding.min40.setOnClickListener{ speakOut(getString(R.string.min40)) }
        binding.min45.setOnClickListener{ speakOut(getString(R.string.min45)) }
        binding.min50.setOnClickListener{ speakOut(getString(R.string.min50)) }
        binding.min55.setOnClickListener{ speakOut(getString(R.string.min55)) }
        binding.min00.setOnClickListener{ speakOut(getString(R.string.min00)) }


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