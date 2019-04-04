package br.com.paulosalvatore.pagseguro_android_turmab.seekbar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import br.com.paulosalvatore.pagseguro_android_turmab.R
import kotlinx.android.synthetic.main.fragment_seek_bar.*

class SeekBarFragment : Fragment() {

    val viewModel by lazy {
        activity?.let {
            ViewModelProviders
                    .of(it)
                    .get(SeekBarViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seek_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeSeekBar()
    }

    private fun subscribeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    viewModel?.seekBarValue?.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        viewModel?.seekBarValue?.observe(this, Observer {
            seekBar.progress = it
        })
    }
}
