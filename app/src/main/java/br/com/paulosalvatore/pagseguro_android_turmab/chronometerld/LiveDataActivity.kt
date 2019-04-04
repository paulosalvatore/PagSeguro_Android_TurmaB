package br.com.paulosalvatore.pagseguro_android_turmab.chronometerld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.paulosalvatore.pagseguro_android_turmab.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val liveDataViewModel =
            ViewModelProviders
                .of(this)
                .get(LiveDataViewModel::class.java)

        liveDataViewModel.elapsedTime.observe(this, Observer {
            textView.text = "Elapsed Time: $it"
        })
    }
}
