package br.com.paulosalvatore.pagseguro_android_turmab.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.paulosalvatore.pagseguro_android_turmab.R
import br.com.paulosalvatore.pagseguro_android_turmab.entities.Word
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class WordListAdapter :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    var items: List<Word> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_item,
            parent,
            false
        )

        return WordViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    class WordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Word) = with(itemView) {
            textView.text = item.word
        }
    }
}
