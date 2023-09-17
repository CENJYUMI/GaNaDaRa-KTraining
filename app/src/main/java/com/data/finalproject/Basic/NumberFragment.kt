package com.data.finalproject.Basic

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentNumberBinding
import java.util.Locale


class NumberFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentNumberBinding
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root


        //Numbers
        binding.zero.setOnClickListener { speakOut(getString(R.string.zero)) }
        binding.one.setOnClickListener { speakOut(getString(R.string.one)) }
        binding.two.setOnClickListener { speakOut(getString(R.string.two)) }
        binding.three.setOnClickListener { speakOut(getString(R.string.three)) }
        binding.four.setOnClickListener { speakOut(getString(R.string.four)) }
        binding.five.setOnClickListener { speakOut(getString(R.string.five)) }
        binding.six.setOnClickListener { speakOut(getString(R.string.six)) }
        binding.seven.setOnClickListener { speakOut(getString(R.string.seven)) }
        binding.eight.setOnClickListener { speakOut(getString(R.string.eight)) }
        binding.nine.setOnClickListener { speakOut(getString(R.string.nine)) }
        binding.ten.setOnClickListener { speakOut(getString(R.string.ten)) }
        binding.twenty.setOnClickListener { speakOut(getString(R.string.twenty)) }
        binding.thirty.setOnClickListener { speakOut(getString(R.string.thirty)) }
        binding.forty.setOnClickListener { speakOut(getString(R.string.forty)) }
        binding.fifty.setOnClickListener { speakOut(getString(R.string.fifty)) }
        binding.sixty.setOnClickListener { speakOut(getString(R.string.sixty)) }
        binding.seventy.setOnClickListener { speakOut(getString(R.string.seventy)) }
        binding.eighty.setOnClickListener { speakOut(getString(R.string.eighty)) }
        binding.ninety.setOnClickListener { speakOut(getString(R.string.ninety)) }
        binding.oneh.setOnClickListener { speakOut(getString(R.string.oneh)) }
        binding.onek.setOnClickListener { speakOut(getString(R.string.onek)) }
        binding.tenk.setOnClickListener { speakOut(getString(R.string.tenk)) }
        binding.hundredk.setOnClickListener { speakOut(getString(R.string.hundredK)) }
        binding.onemil.setOnClickListener { speakOut(getString(R.string.onemil)) }
        binding.tenmil.setOnClickListener { speakOut(getString(R.string.tenmil)) }
        binding.hundredmil.setOnClickListener { speakOut(getString(R.string.hundredmil)) }
        binding.onebil.setOnClickListener { speakOut(getString(R.string.onebil)) }
        //sino
        binding.yeong.setOnClickListener { speakOut(getString(R.string.yeong)) }
        binding.yeong2.setOnClickListener { speakOut(getString(R.string.zero2)) }
        binding.il.setOnClickListener { speakOut(getString(R.string.il)) }
        binding.ii.setOnClickListener { speakOut(getString(R.string.ii)) }
        binding.sam2.setOnClickListener { speakOut(getString(R.string.sam)) }
        binding.saa.setOnClickListener { speakOut(getString(R.string.saa)) }
        binding.oo.setOnClickListener { speakOut(getString(R.string.oo)) }
        binding.yuk.setOnClickListener { speakOut(getString(R.string.yuk)) }
        binding.chil.setOnClickListener { speakOut(getString(R.string.chil)) }
        binding.pal.setOnClickListener { speakOut(getString(R.string.pal)) }
        binding.gu.setOnClickListener { speakOut(getString(R.string.gu)) }
        binding.shib.setOnClickListener { speakOut(getString(R.string.shib)) }
        binding.ishib.setOnClickListener { speakOut(getString(R.string.ishib)) }
        binding.samshib.setOnClickListener { speakOut(getString(R.string.samshib)) }
        binding.sashib.setOnClickListener { speakOut(getString(R.string.sashib)) }
        binding.oshib.setOnClickListener { speakOut(getString(R.string.oshib)) }
        binding.yukshib.setOnClickListener { speakOut(getString(R.string.yukshib)) }
        binding.chilshib.setOnClickListener { speakOut(getString(R.string.chilshib)) }
        binding.palshib.setOnClickListener { speakOut(getString(R.string.palshib)) }
        binding.gushib.setOnClickListener { speakOut(getString(R.string.gushib)) }
        binding.baek.setOnClickListener { speakOut(getString(R.string.baek)) }
        binding.cheon.setOnClickListener { speakOut(getString(R.string.cheon)) }
        binding.man.setOnClickListener { speakOut(getString(R.string.man)) }
        binding.shibman.setOnClickListener { speakOut(getString(R.string.shibman)) }
        binding.baekman.setOnClickListener { speakOut(getString(R.string.baekman)) }
        binding.cheonman.setOnClickListener { speakOut(getString(R.string.cheonman)) }
        binding.eok.setOnClickListener { speakOut(getString(R.string.eok)) }
        binding.baegeok.setOnClickListener { speakOut(getString(R.string.baegeok)) }
        //sino romanization
        binding.one2.setOnClickListener { speakOut(getString(R.string.one2)) }
        binding.two2.setOnClickListener { speakOut(getString(R.string.two2)) }
        binding.three2.setOnClickListener { speakOut(getString(R.string.three2)) }
        binding.four2.setOnClickListener { speakOut(getString(R.string.four2)) }
        binding.five2.setOnClickListener { speakOut(getString(R.string.five2)) }
        binding.six2.setOnClickListener { speakOut(getString(R.string.six2)) }
        binding.seven2.setOnClickListener { speakOut(getString(R.string.seven2)) }
        binding.eight2.setOnClickListener { speakOut(getString(R.string.eight2)) }
        binding.nine2.setOnClickListener { speakOut(getString(R.string.nine2)) }
        binding.ten2.setOnClickListener { speakOut(getString(R.string.ten1)) }
        binding.twenty2.setOnClickListener { speakOut(getString(R.string.twenty2)) }
        binding.thirty2.setOnClickListener { speakOut(getString(R.string.thirty2)) }
        binding.forty2.setOnClickListener { speakOut(getString(R.string.forty2)) }
        binding.fifty2.setOnClickListener { speakOut(getString(R.string.fifty2)) }
        binding.sixty2.setOnClickListener { speakOut(getString(R.string.sixty2)) }
        binding.seventy2.setOnClickListener { speakOut(getString(R.string.seventy2)) }
        binding.eighty2.setOnClickListener { speakOut(getString(R.string.eighty2)) }
        binding.ninety2.setOnClickListener { speakOut(getString(R.string.ninety2)) }
        binding.oneh2.setOnClickListener { speakOut(getString(R.string.oneh2)) }
        binding.onek2.setOnClickListener { speakOut(getString(R.string.onek2)) }
        binding.tenk2.setOnClickListener { speakOut(getString(R.string.tenk2)) }
        binding.hundredk2.setOnClickListener { speakOut(getString(R.string.hundredK2)) }
        binding.onemil2.setOnClickListener { speakOut(getString(R.string.onemil2)) }
        binding.tenmil2.setOnClickListener { speakOut(getString(R.string.tenmil2)) }
        binding.hundredmil2.setOnClickListener { speakOut(getString(R.string.hundredmil2)) }
        binding.onebil2.setOnClickListener { speakOut(getString(R.string.oneBil2)) }
        //native
        binding.hana.setOnClickListener { speakOut(getString(R.string.hana)) }
        binding.dul.setOnClickListener { speakOut(getString(R.string.dul)) }
        binding.set.setOnClickListener { speakOut(getString(R.string.set)) }
        binding.net.setOnClickListener { speakOut(getString(R.string.net)) }
        binding.daseot.setOnClickListener { speakOut(getString(R.string.daseot)) }
        binding.yeoseot.setOnClickListener { speakOut(getString(R.string.yeoseot)) }
        binding.ilgop.setOnClickListener { speakOut(getString(R.string.ilgop)) }
        binding.yeodeol.setOnClickListener { speakOut(getString(R.string.yeodeol)) }
        binding.ahop.setOnClickListener { speakOut(getString(R.string.ahop)) }
        binding.yeol.setOnClickListener { speakOut(getString(R.string.yeol)) }
        binding.seumul.setOnClickListener { speakOut(getString(R.string.seumul)) }
        binding.seoreun.setOnClickListener { speakOut(getString(R.string.seoreun)) }
        binding.maheun.setOnClickListener { speakOut(getString(R.string.maheun)) }
        binding.shwin.setOnClickListener { speakOut(getString(R.string.shwin)) }
        binding.yesun.setOnClickListener { speakOut(getString(R.string.yesun)) }
        binding.ilheun.setOnClickListener { speakOut(getString(R.string.ilheun)) }
        binding.yeodeun.setOnClickListener { speakOut(getString(R.string.yeodeun)) }
        binding.aheun.setOnClickListener { speakOut(getString(R.string.aheun)) }
        binding.baek3.setOnClickListener { speakOut(getString(R.string.baek)) }
        binding.cheon3.setOnClickListener { speakOut(getString(R.string.cheon)) }
        binding.man3.setOnClickListener { speakOut(getString(R.string.man)) }
        binding.shibman3.setOnClickListener { speakOut(getString(R.string.shibman)) }
        binding.baekman3.setOnClickListener { speakOut(getString(R.string.baekman)) }
        binding.cheonman3.setOnClickListener { speakOut(getString(R.string.cheonman)) }
        binding.eok3.setOnClickListener { speakOut(getString(R.string.eok)) }
        binding.baegeok3.setOnClickListener { speakOut(getString(R.string.baegeok)) }
        //native romanization
        binding.one3.setOnClickListener { speakOut(getString(R.string.one3)) }
        binding.two3.setOnClickListener { speakOut(getString(R.string.two3)) }
        binding.three3.setOnClickListener { speakOut(getString(R.string.three3)) }
        binding.four3.setOnClickListener { speakOut(getString(R.string.four3)) }
        binding.five3.setOnClickListener { speakOut(getString(R.string.five3)) }
        binding.six3.setOnClickListener { speakOut(getString(R.string.six3)) }
        binding.seven3.setOnClickListener { speakOut(getString(R.string.seven3)) }
        binding.eight3.setOnClickListener { speakOut(getString(R.string.eight3)) }
        binding.nine3.setOnClickListener { speakOut(getString(R.string.nine3)) }
        binding.ten3.setOnClickListener { speakOut(getString(R.string.ten3)) }
        binding.twenty3.setOnClickListener { speakOut(getString(R.string.twenty3)) }
        binding.thirty3.setOnClickListener { speakOut(getString(R.string.thirty3)) }
        binding.forty3.setOnClickListener { speakOut(getString(R.string.forty2)) }
        binding.fifty3.setOnClickListener { speakOut(getString(R.string.fifty3)) }
        binding.sixty3.setOnClickListener { speakOut(getString(R.string.sixty3)) }
        binding.seventy3.setOnClickListener { speakOut(getString(R.string.seventy3)) }
        binding.eighty3.setOnClickListener { speakOut(getString(R.string.eighty3)) }
        binding.ninety3.setOnClickListener { speakOut(getString(R.string.ninety3)) }
        binding.oneh3.setOnClickListener { speakOut(getString(R.string.oneh2)) }
        binding.onek3.setOnClickListener { speakOut(getString(R.string.onek2)) }
        binding.tenk4.setOnClickListener { speakOut(getString(R.string.tenk2)) }
        binding.hundredk3.setOnClickListener { speakOut(getString(R.string.hundredK2)) }
        binding.onemil4.setOnClickListener { speakOut(getString(R.string.onemil2)) }
        binding.tenmil4.setOnClickListener { speakOut(getString(R.string.tenmil2)) }
        binding.hundredmil3.setOnClickListener { speakOut(getString(R.string.hundredmil2)) }
        binding.onebil3.setOnClickListener { speakOut(getString(R.string.oneBil2)) }


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
