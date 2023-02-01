package uz.it_teacher.lesson4tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var matrix = Array(3) { IntArray(3) { -1 } }
    var active = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        active_player.text = "Player X"

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
        val playerO = bundle!!.get("playerO")
        val playerX = bundle.get("playerX")

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

    fun finishGame(iswinner: Int) {
        restart.visibility = View.VISIBLE
        winner.text = "Winner is " + iswinner
        img0.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false

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
}