package br.com.paulosalvatore.pagseguro_android_turmab.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.paulosalvatore.pagseguro_android_turmab.R
import br.com.paulosalvatore.pagseguro_android_turmab.entities.Word
import br.com.paulosalvatore.pagseguro_android_turmab.view.NewWordActivity.Companion.WORD_KEY
import br.com.paulosalvatore.pagseguro_android_turmab.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.startActivityForResult

class MainActivity : AppCompatActivity() {

    companion object {
        private const val NEW_WORD_REQUEST_CODE = 1
    }

    private val wordViewModel by lazy {
        ViewModelProviders.of(this).get(WordViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel.allWords.observe(this, Observer {
            adapter.items = it
        })

        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            startActivityForResult<NewWordActivity>(NEW_WORD_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val word = Word(it.getStringExtra(WORD_KEY))
                    wordViewModel.insert(word)
                }
            } else {
                fab.longSnackbar("Word was empty.", "Try again") {
                    fab.performClick()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
