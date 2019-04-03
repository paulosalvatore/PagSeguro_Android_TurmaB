package br.com.paulosalvatore.pagseguroandroidturmab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableDouble
import br.com.paulosalvatore.pagseguroandroidturmab.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by SetContentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(
//            this,
//            R.layout.activity_main
//        )

        val game = Game(
            "Donkey Kong",
            1981,
            "https://vignette.wikia.nocookie.net/fantendo/images/b/b5/SuperMarioParty_DonkeyKong.png/revision/latest?cb=20181005213911",
            4.0
        )

        binding.game = game

        tvRating.setOnClickListener {
            game.rating = game.rating + 0.1
//            game.rating.set(game.rating.get() + 0.1)
        }
    }
}
