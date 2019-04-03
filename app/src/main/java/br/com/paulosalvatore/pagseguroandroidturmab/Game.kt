package br.com.paulosalvatore.pagseguroandroidturmab

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Game(
    val name: String,
    val launchYear: Int,
    val imageUrl: String,
    rating: Double
) : BaseObservable() {
    /*constructor(
        name: String,
        launchYear: Int,
        imageUrl: String,
        rating: Double
    ) : this(name, launchYear, imageUrl, ObservableDouble(rating))*/

    val isClassic = launchYear < 2000

    @get:Bindable
    var rating by bindable(rating, BR.rating)
    /*set(value) {
        if (field != value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }
    }*/
}
