package com.example.coloringapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coloringapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:Myadapter
    private val list= ArrayList<Int>()
    private var position=0
    private val steps= arrayOf(1,11,8,23,20,25)
    private val stepbis= arrayOf(0,4,8,12,16,20,24)
    private val countDownTimer=object: CountDownTimer(7000,1000) {
        var step=0

        override fun onTick(millisUntilFinished: Long) {
                        list.shuffle()
            binding.constrainLayout.setBackgroundColor(ContextCompat.getColor(applicationContext,list[10]))
            adapter=Myadapter(applicationContext,list,stepbis[position]+step)
            binding.recylerview.adapter=adapter
            binding.recylerview.layoutManager=GridLayoutManager(applicationContext,4)
            position++
        }

        override fun onFinish() {
            position=0
            step=Random.nextInt(4)
            this.start()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(arrayListOf(R.color.color0,R.color.color1,R.color.color2,R.color.color3,R.color.color4,
            R.color.color5,R.color.color6,R.color.color7,R.color.color8,R.color.color9,R.color.color10,
            R.color.color11,R.color.color12,R.color.color13,R.color.color14,R.color.color15,R.color.color16,
            R.color.color17,R.color.color18,R.color.color19,R.color.color20,R.color.color21,R.color.color22,
            R.color.color23,R.color.color24,R.color.color25,R.color.color26,R.color.color27))
        countDownTimer.start()




    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }

    override fun onRestart() {
        super.onRestart()
        position=0
        countDownTimer.start()
    }
}