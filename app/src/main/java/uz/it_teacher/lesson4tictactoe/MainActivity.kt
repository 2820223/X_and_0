package uz.it_teacher.lesson4tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true
    var chek = 0
    lateinit var win:String
    var soni =0



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        active_player.text = "Player X"
        goResult()


        img0.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        restart.setOnClickListener {
            restart()
        }




        val bundle: Bundle? = intent.extras
        var player0 = intent.getStringExtra("player0")
        var playerX = intent.getStringExtra("playerX")


        Log.d("TAG", playerX.toString())

        if (playerX != null) {
            leftX.text = playerX.toString()
        }
        if (player0 != null) {
            right0.text = player0.toString()
        }
    }





    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        val img = findViewById<ImageView>(p0!!.id)
        var t = img.tag.toString().toInt()
        var col: Int = t / 3
        var row: Int = t % 3
        if (matrix[col][row] == -1) {
            if (active) {
                img.setImageResource(R.drawable.x)
                active = false
                matrix[col][row] = 1
                active_player.text = "Player 0"
                isWinner(1)
            } else {
                img.setImageResource(R.drawable.zero)
                active = true
                matrix[col][row] = 0
                active_player.text = "Player X"
                isWinner(0)
            }


            if (chek==9){
               finishGame(-1)
            Log.d("chek",chek.toString())

            }
            chek++
        }
    }

    @SuppressLint("SetTextI18n")
    fun isWinner(a: Int) {
        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == a) {
                    count++
                }
            }
            if (count == 3) {
                finishGame(a)
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == a) {
                    count++
                }
            }
            if (count == 3) {
                finishGame(a)
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            finishGame(a)
            return
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[j][i] == a) {
                        count++
                    }
                }
            }
        }
        if (count == 3) {
            finishGame(a)
            return
        }


    }



    @SuppressLint("SetTextI18n")
    fun finishGame(iswinner: Int) {
        soni++
        restart.visibility = View.VISIBLE

       if (iswinner==-1) {
           winner.text = "It's drought"

       }else {
           winner.text = "Winner is " + iswinner
       }
        chek =0
        img0.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false


        if (iswinner == 1) {
            leftsourse.text = (leftsourse.text.toString().toInt() + 1).toString()
        } else if  (iswinner == 0 ){
            rightsourse.text = (rightsourse.text.toString().toInt() + 1).toString()


        }
soni++
    }



    @SuppressLint("SetTextI18n")
    fun restart() {
        matrix = Array(3) { IntArray(3) { -1 } }
        active = true
        active_player.text = "Player X"
        restart.visibility = View.INVISIBLE
        winner.text = ""
        img0.setImageDrawable(null)
        img1.setImageDrawable(null)
        img2.setImageDrawable(null)
        img3.setImageDrawable(null)
        img4.setImageDrawable(null)
        img5.setImageDrawable(null)
        img6.setImageDrawable(null)
        img7.setImageDrawable(null)
        img8.setImageDrawable(null)


        img0.isEnabled = true
        img1.isEnabled = true
        img2.isEnabled = true
        img3.isEnabled = true
        img4.isEnabled = true
        img5.isEnabled = true
        img6.isEnabled = true
        img7.isEnabled = true
        img8.isEnabled = true

    }
    fun goResult(){
        if (soni == 2){
            active_player.text="fsf"
        if (rightsourse.text.toString().toInt()>leftsourse.text.toString().toInt()){
            win=player0.text.toString()
        }
        else{
            win =playerX.text.toString()
        }



        var intent = Intent(this, Result::class.java)
        intent.putExtra("win", win)
            startActivity(intent)
    }
    }

    }

