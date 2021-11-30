package kks.jpeople

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import kks.jpeople.databinding.ActivityLoadingBinding

class LoadingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionBar = supportActionBar
        actionBar?.hide()

        val animation = AnimationUtils.loadAnimation(this, R.anim.fadeinlogo)
        binding.imageviewLogo.startAnimation(animation)
        binding.imageViewChurch.startAnimation(animation)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
                val intent = Intent(this@LoadingActivity, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                Toast.makeText(this@LoadingActivity, "제이피플에 오신것을 환영합니다", Toast.LENGTH_SHORT).show()
                finish()
        }, 1500)
    }
}