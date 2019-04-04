package br.com.paulosalvatore.pagseguro_android_turmab.chronometervm

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.paulosalvatore.pagseguro_android_turmab.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProviders
                .of(this)
                .get(ChronometerViewModel::class.java)

//        val vm = getViewModel<ChronometerViewModel>()

        if (viewModel.startTime == 0L) {
            viewModel.startTime = SystemClock.elapsedRealtime()
        }

        chronometer.base = viewModel.startTime
        chronometer.start()
    }
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel() =
    ViewModelProviders
        .of(this)
        .get(T::class.java)
