package uz.exemple.less57_youtubeui_white_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less57_youtubeui_white_kotlin.R
import uz.exemple.less57_youtubeui_white_kotlin.model.Feed

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var ITEM_SHORT = 0
    var ITEM_VIDEO = 1

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        if (item.shortsList != null) {
            return  ITEM_SHORT
        } else return  ITEM_VIDEO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder {
        if (viewType == ITEM_SHORT){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_shorts, parent, false)
            return ShortViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is FeedViewHolder){
            holder.iv_profile.setImageResource(item.profile)
            holder.iv_video.setImageResource(item.photo)
            holder.title.setText(item.title)
            holder.channel.setText(item.channel.toString() + " · ")
            holder.countV.setText(item.count_views.toString() + " · ")
            holder.created.setText(item.created)
            holder.time.setText(item.time)
        }
        if (holder is ShortViewHolder){
            val shorts = items[position]
            context = holder.itemView.getContext()

            holder.rv_shorts.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val adapter = ShortsAdapter(context, shorts.shortsList)
            holder.rv_shorts.adapter = adapter
        }

    }
    override fun getItemCount(): Int {
        return items.size
    }

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ShapeableImageView
        var iv_video: ImageView
        var title: TextView
        var channel: TextView
        var countV: TextView
        var created: TextView
        var time: TextView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            iv_video = itemView.findViewById(R.id.iv_video)
            title = itemView.findViewById(R.id.tv_title)
            channel = itemView.findViewById(R.id.tv_channel)
            countV = itemView.findViewById(R.id.tv_countV)
            created = itemView.findViewById(R.id.tv_created)
            time = itemView.findViewById(R.id.tv_videoTime)
        }
    }
    class ShortViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var rv_shorts: RecyclerView

        init {
            rv_shorts = itemView.findViewById(R.id.rv_shorts)
        }
    }

}