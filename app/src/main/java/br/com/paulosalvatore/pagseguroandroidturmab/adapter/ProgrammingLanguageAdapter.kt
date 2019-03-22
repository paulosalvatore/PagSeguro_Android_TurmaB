package br.com.paulosalvatore.pagseguroandroidturmab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.paulosalvatore.pagseguroandroidturmab.R
import br.com.paulosalvatore.pagseguroandroidturmab.domain.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

class ProgrammingLanguageAdapter(
    val items: List<ProgrammingLanguage>,
    val listener: (ProgrammingLanguage) -> Unit
) : RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.programming_language_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: ProgrammingLanguage,
                     listener: (ProgrammingLanguage) -> Unit) = with(itemView) {
            ivMain.setImageResource(item.imageResourceId)
            tvTitle.text = item.title
            tvLaunchYear.text = item.launchYear.toString()
            tvDescription.text = item.description

            setOnClickListener { listener(item) }
        }
    }
}
