package uz.it_teacher.lesson4tictactoe

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Result : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
    }





        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_view)


        var mutlaqGolib = intent.getStringExtra("win")

        var txt = findViewById<TextView>(R.id.txt)

        txt.text = "Winner is : " + mutlaqGolib.toString()
    }


}