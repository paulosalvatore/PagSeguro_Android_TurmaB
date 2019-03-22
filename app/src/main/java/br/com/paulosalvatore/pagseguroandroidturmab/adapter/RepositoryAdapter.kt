package br.com.paulosalvatore.pagseguroandroidturmab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.paulosalvatore.pagseguroandroidturmab.R
import br.com.paulosalvatore.pagseguroandroidturmab.api.Repository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryAdapter(
    val items: List<Repository>,
    val listener: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.repository_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Repository,
                     listener: (Repository) -> Unit) = with(itemView) {
//            ivMain.setImageResource(item.imageResourceId)
            Glide.with(itemView.context).load(item.owner?.avatarUrl).into(ivMain)
            tvTitle.text = item.name
            tvOwner.text = item.owner?.login
            tvDescription.text = item.description

            setOnClickListener { listener(item) }
        }
    }
}
