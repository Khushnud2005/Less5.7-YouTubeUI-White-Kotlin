package uz.exemple.less57_youtubeui_white_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less57_youtubeui_white_kotlin.R
import uz.exemple.less57_youtubeui_white_kotlin.model.ShortsModel

class ShortsAdapter(var context: Context, var items: ArrayList<ShortsModel>?):RecyclerView.Adapter<ShortsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_short_video,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items!![position]
        holder.image.setImageResource(item.image_short)
        holder.title.setText(item.title)
        holder.count_views.setText(item.view_count)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var count_views:TextView
        init {
            image = itemView.findViewById(R.id.iv_shortVideo)
            title = itemView.findViewById(R.id.tv_title_shortVideo)
            count_views = itemView.findViewById(R.id.tv_count_shortVideo)
        }
    }
}