package uz.it_teacher.lesson4tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        button.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playerO", "Sarvar")
            intent.putExtra("playerX", "Elshod")
            startActivity(intent)
        }
    }
}