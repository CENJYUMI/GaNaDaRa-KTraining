package com.data.finalproject.Basic

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.data.finalproject.UnitRecycler.UnitsAdapter
import com.data.finalproject.UnitRecycler.UnitsData
import com.data.finalproject.UnitRecycler.UnitsInfoActivity
import com.data.finalproject.databinding.FragmentUnitsBinding

import java.util.Locale



class UnitsFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentUnitsBinding
    private lateinit var tts: TextToSpeech
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUnitsBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = binding.UnitsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        tts = TextToSpeech(requireContext(), this)

        val voice = Voice("en-us-x-sfg#female_2-local", Locale.KOREAN, 400, 200, true, null)
        tts.voice = voice

        val koreanUnits = listOf(
            UnitsData("명","individual", "사람", "person", "한 명, 두 명, 세 명, 네 명,…" ),
            UnitsData("개","piece", "과일", "fruits", "한 개, 두 개, 세 개, 네 개,…" ),
            UnitsData("마리","animal", "동물", "animals", "한 마리, 두 마리, 세 마리, 네 마리,…" ),
            UnitsData("대","unit", "기계류, 자동차, \n텔레비전, 냉장고 ", "machinery, car, \nTV, refrigerator", "한 대, 두 대, 세 대, 네 대,…" ),
            UnitsData("벌","pair", "옷, 정장, 한복, 수저", "clothes, suits, Korean traditional clothes, spoon and chopsticks ", "한 벌, 두 벌, 세 벌, 네 벌,…" ),
            UnitsData("켤레","pair", "양말, 신발, 장갑", "socks, shoes, gloves", "한 켤레, 두 켤레, 세 켤레, 네 켤레,…" ),
            UnitsData("송이","bundle/blossom", "포도, 바나나, 꽃 ", "grape, banana, flower", "한 송이, 두 송이, 세 송이, 네 송이,…" ),
            UnitsData("채","building", "집", "house", "한 채, 두 채, 세 채, 네 채,…" ),
            UnitsData("그릇","bowl", "밥, 국, 반찬", "rice, soup, side dish", "한 그릇, 두 그릇, 세 그릇, 네 그릇,…" ),
            UnitsData("자루","piece", "쌀, 연필", "rice, pencil", "한 자루, 두 자루, 세 자루, 네 자루,…" ),
            UnitsData("잔","glass", "차, 커피, 주스", "tea, coffee, juice", "한 잔, 두 잔, 세 잔, 네 잔,…" ),
            UnitsData("장","sheet", "종이, 지폐, 수표, 카드", "paper, bill, check, card", "한 장, 두 장, 세 장, 네 장,…" ),
            UnitsData("병","bottle", "물, 음료, 맥주", "water, beverages, beer", "한 병, 두 병, 세 병, 네 병,…" ),
            UnitsData("갑","pack", "담배", "cigarette", "한 갑, 두 갑, 세 갑, 네 갑,…" ),
            UnitsData("봉지","pack", "과자", "snacks", "한 봉지, 두 봉지, 세 봉지, 네 봉지,…" ),
            UnitsData("통","can", "페인트, 수박", "paint, water melon", "한 통, 두 통, 세 통, 네 통,…" ),
            UnitsData("알","al", "계란, 곡식", "egg, grain", "한 알, 두 알, 세 알, 네 알,…" ),
        )

        recyclerView.adapter = UnitsAdapter(koreanUnits, this)


        return view
    }


     fun onItemClick(item: UnitsData, position: Int) {

         val intent = Intent(requireContext(), UnitsInfoActivity::class.java)
         intent.putExtra("unitName", item.unitName)
         intent.putExtra("unitMeaning", item.unitMeaning)
         intent.putExtra("whereToUseKorean", item.whereToUseKorean)
         intent.putExtra("whereToUseEnglish", item.whereToUseEnglish)
         intent.putExtra("example", item.example)


         requireContext().startActivity(intent)

     }

    override fun onInit(status: Int) {

    }
}