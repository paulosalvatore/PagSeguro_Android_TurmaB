package br.com.paulosalvatore.pagseguroandroidturmab

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.programming_language_item.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val kotlin = ProgrammingLanguage(
                R.drawable.ic_developer_board,
                "Kotlin",
                2010,
                "Kotlin description"
        )

        val items = listOf(kotlin, kotlin)

        val adapter = ProgrammingLanguageAdapter(items) {
//            Toast.makeText(this, "Clicked item: ${it.title}", Toast.LENGTH_LONG).show()
            longToast("Clicked item: ${it.title}")
        }
        recyclerView.adapter = adapter

//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("nome", "Paulo")
//        intent.putExtra("numero", 1)
//        startActivity(intent)

//        startActivity<MainActivity>(
//            "nome" to "Paulo",
//            "numero" to 1
//        )

//        alert("Clique em algum botão.", "Title") {
//            yesButton {
//                toast("Yes")
//            }
//            noButton {
//                toast("No")
//            }
//        }.show()

        doAsync {
            val imagem = "CarregarImagem - LongOperationResult"
            uiThread {
//                ivMain.setImageBitmap()
                print(imagem)
            }
        }
    }
}
