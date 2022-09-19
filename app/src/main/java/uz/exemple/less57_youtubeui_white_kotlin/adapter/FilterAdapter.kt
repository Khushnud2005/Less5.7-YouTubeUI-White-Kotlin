package uz.exemple.less57_youtubeui_white_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less57_youtubeui_white_kotlin.R
import uz.exemple.less57_youtubeui_white_kotlin.model.Filter

class FilterAdapter(var context: Context, var items: ArrayList<Filter>) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    var EXPLORE_ITEM = 0
    var FILTER_ITEM = 1

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return if (item.title == "Explore") {
            EXPLORE_ITEM
        } else FILTER_ITEM
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == EXPLORE_ITEM){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_filter_exp, parent, false)
            return ViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.tv_title.text = item.title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_title: TextView

        init {
            tv_title = itemView.findViewById(R.id.tv_title)
        }
    }
}