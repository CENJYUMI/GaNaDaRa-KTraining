package com.data.finalproject.basic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentDateBinding
import java.util.Locale


class DateFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentDateBinding
    private lateinit var textToSpeech: TextToSpeech


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDateBinding.inflate(inflater, container, false)
        val view = binding.root


    binding.ilwol.setOnClickListener{ speakOut(getString(R.string.ilwol)) }
    binding.iwol.setOnClickListener{ speakOut(getString(R.string.iwol)) }
    binding.samwol.setOnClickListener{ speakOut(getString(R.string.samwol)) }
    binding.sawol.setOnClickListener{ speakOut(getString(R.string.sawol)) }
    binding.owol.setOnClickListener{ speakOut(getString(R.string.owol)) }
    binding.yuwol.setOnClickListener{ speakOut(getString(R.string.yuwol)) }
    binding.chilwol.setOnClickListener{ speakOut(getString(R.string.chilwol)) }
    binding.palwol.setOnClickListener{ speakOut(getString(R.string.palwol)) }
    binding.guwol.setOnClickListener{ speakOut(getString(R.string.guwol)) }
    binding.shiwol.setOnClickListener{ speakOut(getString(R.string.shiwol)) }
    binding.shibilwol.setOnClickListener{ speakOut(getString(R.string.shibilwol)) }
    binding.shibiwol.setOnClickListener{ speakOut(getString(R.string.shibiwol)) }

    binding.ilil.setOnClickListener{ speakOut(getString(R.string.ilil)) }
    binding.iiil.setOnClickListener{ speakOut(getString(R.string.iil)) }
    binding.samil.setOnClickListener{ speakOut(getString(R.string.samil)) }
    binding.sail.setOnClickListener{ speakOut(getString(R.string.sail)) }
    binding.oil.setOnClickListener{ speakOut(getString(R.string.ooil)) }
    binding.yukil.setOnClickListener{ speakOut(getString(R.string.yukil)) }
    binding.chilil.setOnClickListener{ speakOut(getString(R.string.chilil)) }
    binding.palil.setOnClickListener{ speakOut(getString(R.string.palil)) }
    binding.guil.setOnClickListener{ speakOut(getString(R.string.guil)) }
    binding.shibil.setOnClickListener{ speakOut(getString(R.string.shibil)) }
    binding.shibilil.setOnClickListener{ speakOut(getString(R.string.shibilil)) }
    binding.shibiil.setOnClickListener{ speakOut(getString(R.string.shibiil)) }
    binding.shibsamil.setOnClickListener{ speakOut(getString(R.string.shibsamil)) }
    binding.shibsail.setOnClickListener{ speakOut(getString(R.string.shibsail)) }
    binding.shiboil.setOnClickListener{ speakOut(getString(R.string.shibooil)) }
    binding.shibyukil.setOnClickListener{ speakOut(getString(R.string.shibyukil)) }
    binding.shibchilil.setOnClickListener{ speakOut(getString(R.string.shibchilil)) }
    binding.shibpalil.setOnClickListener{ speakOut(getString(R.string.shibpalil)) }
    binding.shibguil.setOnClickListener{ speakOut(getString(R.string.shibguil)) }
    binding.iishibil.setOnClickListener{ speakOut(getString(R.string.iishibil)) }
    binding.iishibilil.setOnClickListener{ speakOut(getString(R.string.iishibilil)) }
    binding.iishibiiil.setOnClickListener{ speakOut(getString(R.string.iishibiiil)) }
    binding.iishibsamil.setOnClickListener{ speakOut(getString(R.string.iishibsamil)) }
    binding.iishibsail.setOnClickListener{ speakOut(getString(R.string.iishibsail)) }
    binding.iishiboil.setOnClickListener{ speakOut(getString(R.string.iishibooil)) }
    binding.iishibchilil.setOnClickListener{ speakOut(getString(R.string.iishibchilil)) }
    binding.iishibpalil.setOnClickListener{ speakOut(getString(R.string.iishibpalil)) }
    binding.iishibguil.setOnClickListener{ speakOut(getString(R.string.iishibguil)) }
    binding.samshibil.setOnClickListener{ speakOut(getString(R.string.samshibil)) }
    binding.samshibilil.setOnClickListener{ speakOut(getString(R.string.samshibilil)) }

    binding.sunday2.setOnClickListener{ speakOut(getString(R.string.sunday2)) }
    binding.monday2.setOnClickListener{ speakOut(getString(R.string.monday2)) }
    binding.tuesday2.setOnClickListener{ speakOut(getString(R.string.tuesday2)) }
    binding.wednesday2.setOnClickListener{ speakOut(getString(R.string.wednesday2)) }
    binding.thursday2.setOnClickListener{ speakOut(getString(R.string.thursday2)) }
    binding.friday2.setOnClickListener{ speakOut(getString(R.string.friday2)) }
    binding.saturday2.setOnClickListener{ speakOut(getString(R.string.saturday2)) }


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