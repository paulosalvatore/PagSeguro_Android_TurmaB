package br.com.paulosalvatore.pagseguroandroidturmab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        // Exemplo 1

        val observable = Observable.create<String> { subscriber ->
            subscriber.onNext("ResultadoString")
        }

        val disposable = observable.subscribe {
            println("onNext: $it")
        }

        disposable.dispose()

        // Exemplo 2

        val observable1 = Observable.just(1, 2, 3)

        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe $d")
            }

            override fun onNext(t: Int) {
                println("onNext $t")
            }

            override fun onComplete() {
                println("onComplete")
            }

            override fun onError(e: Throwable) {
                println("onError $e")
            }
        }

        observable1.subscribe(observer)

        val consumer = object : Consumer<Int> {
            override fun accept(t: Int) {
                println("onNext: $t")
            }
        }

        // Exemplo 3
        val disposable1 = observable1
            .map { it * 2 }
            .filter { it < 6 }
            .subscribe(consumer)

        disposable1.dispose()

        // Exemplo 4
        val observable2 = Observable.interval(1000L, TimeUnit.MILLISECONDS)
        */

        val etNameObservable = RxTextView
            .textChanges(etName)
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable(BackpressureStrategy.LATEST)

        val etYearObservable = RxTextView
            .textChanges(etYear)
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable(BackpressureStrategy.LATEST)

        disposable = Flowables.combineLatest(
            etNameObservable,
            etYearObservable
        ) { newName, newYear ->
            val nameValid = newName.length >= 3
            if (!nameValid) {
                etName.error = "Invalid name"
            }

            val yearValid = newYear.length == 4
            if (!yearValid) {
                etYear.error = "Invalid year"
            }

            nameValid && yearValid
        }.subscribe { formValid ->
            btAdd.setBackgroundColor(
                ContextCompat.getColor(
                    applicationContext,
                    if (formValid) R.color.colorPrimary else android.R.color.darker_gray
                )
            )
        }
    }

    override fun onDestroy() {
        disposable.dispose()

        super.onDestroy()
    }
}
