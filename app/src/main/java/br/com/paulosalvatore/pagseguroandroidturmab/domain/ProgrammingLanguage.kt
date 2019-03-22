package br.com.paulosalvatore.pagseguroandroidturmab.domain

import androidx.annotation.DrawableRes

data class ProgrammingLanguage(
        @DrawableRes
        val imageResourceId: Int,
        val title: String,
        val launchYear: Int,
        val description: String
)
