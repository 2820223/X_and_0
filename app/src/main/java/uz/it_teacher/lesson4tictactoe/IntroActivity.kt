package uz.it_teacher.lesson4tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val playerX = playerX.text.toString()
        val player0 = player0.text.toString()

        start.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playerX", playerX)
            intent.putExtra("player0", player0)
            startActivity(intent)
        }
    }
}