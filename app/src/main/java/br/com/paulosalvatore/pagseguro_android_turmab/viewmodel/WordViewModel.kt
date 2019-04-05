package br.com.paulosalvatore.pagseguro_android_turmab.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.paulosalvatore.pagseguro_android_turmab.entities.Word
import br.com.paulosalvatore.pagseguro_android_turmab.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WordRepository(application)

    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}
