package br.com.paulosalvatore.pagseguro_android_turmab.seekbar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {

    val seekBarValue = MutableLiveData<Int>()
}
