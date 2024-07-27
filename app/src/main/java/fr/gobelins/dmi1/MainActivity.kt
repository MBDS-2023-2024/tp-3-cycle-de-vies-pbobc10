package fr.gobelins.dmi1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnHomeCompute: Button
    private lateinit var btnGoogleSearch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHomeCompute = findViewById(R.id.btn_home_compute)
        btnGoogleSearch = findViewById(R.id.btn_search)

        btnHomeCompute.setOnClickListener {
            val intent = Intent(this, ComputeActivity::class.java)
            intent.extras?.putString("operation", "ADD")
            startActivity(intent)
        }

        btnGoogleSearch.setOnClickListener {
            var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.fr"))
            startActivity(browserIntent)
        }
    }
}