package com.data.finalproject.basic

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
import com.data.finalproject.directionRecycler.DirectionAdapter
import com.data.finalproject.directionRecycler.DirectionDataClass
import com.data.finalproject.directionRecycler.DirectionInfo3Activity
import com.data.finalproject.databinding.FragmentDirectionBinding
import java.util.Locale


class DirectionFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentDirectionBinding
    private lateinit var tts: TextToSpeech
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDirectionBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = binding.DirectionRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        tts = TextToSpeech(requireContext(), this)

        val voice = Voice("en-us-x-sfg#female_2-local", Locale.KOREAN, 400, 200, true, null)
        tts.voice = voice

        val koreanDirection = listOf(
            DirectionDataClass("위","above/over", "휴대폰이 책상 위에 있습니다","the cell phone is on the desk"),
            DirectionDataClass("아래","below/under", "고양이는 책상 아래에 있습니다","the cat is under the desk"),
            DirectionDataClass("앞","in front of", "의자는 책상 앞에 있습니다","The chair is in front of the desk"),
            DirectionDataClass("뒤","at the back of", "편의점은 약국 뒤에 있습니다","The convenience store is behind the pharmacy"),
            DirectionDataClass("옆","beside", "가방은 책상 옆에 있습니다","The bag is next to the desk"),
            DirectionDataClass("오른쪽","right side", "옷장은 책상 오른쪽에 있습니다","The closet is to the right of the desk."),
            DirectionDataClass("왼쪽","left side", "책상은 옷장 왼쪽에 있습니다","The desk is to the left of the closet"),
            DirectionDataClass("건나편","across from", "은행은 백화점 건나편에 있습니다","The bank is across from the department store."),
            DirectionDataClass("층","floor", "새워실은 2층에 있습니다","The new room is on the 2nd floor."),
            DirectionDataClass("같은 층","same floor", "사무실은 휴게실과 같은 층에 있습니다","The office is on the same floor as the break room."),
            DirectionDataClass("안","inside", "건물은 건물 안에 있습니다","The building is inside the building"),
            DirectionDataClass("밖","outside", "약국은 건물 밖에 있습니다","The pharmacy is outside the building."),
            DirectionDataClass("지하","basement", "주차장은 지하에 있습니다","Parking lot is underground"),
            DirectionDataClass("옥상","rooftop", "물탱크는 옥상에 있습니다","The water tank is on the roof."),
            DirectionDataClass("사이","between", "은행은 편의점과 우체국 사이에 있습니다","The bank is located between the convenience store and the post office."),

        )

        recyclerView.adapter = DirectionAdapter (koreanDirection, this)


        return view
    }

    fun onItemClick(item: DirectionDataClass, position: Int) {


        val intent = Intent(requireContext(), DirectionInfo3Activity::class.java)
        intent.putExtra("koreanDirection", item.koreanDirection)
        intent.putExtra("exampleDirection", item.exampleDirection)
        intent.putExtra("englishDirection", item.englishDirecton)
        intent.putExtra("exampleMeaning", item.exampleMeaning)



        requireContext().startActivity(intent)

    }

    override fun onInit(status: Int) {

    }
}


