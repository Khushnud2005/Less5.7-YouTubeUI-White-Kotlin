package uz.exemple.less57_youtubeui_white_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less57_youtubeui_white_kotlin.adapter.FeedAdapter
import uz.exemple.less57_youtubeui_white_kotlin.adapter.FilterAdapter
import uz.exemple.less57_youtubeui_white_kotlin.model.Feed
import uz.exemple.less57_youtubeui_white_kotlin.model.Filter
import uz.exemple.less57_youtubeui_white_kotlin.model.ShortsModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFilter: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerFilter = findViewById<RecyclerView>(R.id.recyclerFilter)
        recyclerFilter.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerFeed = findViewById<RecyclerView>(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshFilterAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshFilterAdapter(filters: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, filters)
        recyclerFilter.adapter = adapter
    }

    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    fun getAllFilters(): ArrayList<Filter> {
        val filters: ArrayList<Filter> = ArrayList()
        filters.add(Filter("Explore"))
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        return filters
    }

    fun getAllFeeds(): ArrayList<Feed> {
        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        feeds.add(Feed(R.drawable.profile1,R.drawable.fon1,"QAYTISH seriali I: Bu tush emas, SON!/ Xvicha “Milan”ni xivichladi/ Hujumchi Noyer/ #allegriout ","Xayrulla HAMIDOV","7k views","22:02","15 hour ago"  ))
        feeds.add(Feed("Shorts", getShorts()))
        feeds.add(Feed(R.drawable.profile2,R.drawable.fon2,"How to Make a Clean Architecture Note App (MVVM / CRUD / Jetpack Compose) - Android Studio Tutorial","Philipp Lackner","158k views","2:23:58","1 year ago"))

        feeds.add(Feed(R.drawable.profile3,R.drawable.fon3,"Studentlar dardi\uD83D\uDE02","Sariq Bola TV","208k views","2:12","1 week ago"))
        feeds.add(Feed(R.drawable.profile4, R.drawable.fon4,"O‘zbekistondagi ta’lim illyuziyasi – Oliy ta’lim | SUBYEKTIV","SUBYEKTIV", "990k views","1:19:14","2 weeks ago"))
        feeds.add(Feed(R.drawable.profile5,R.drawable.fon5,"Laravel 9 Ecom - Part 40: Checkout Updates | Checkout place order in laravel 9 livewire","Funda of Web IT","363 views","12:19","3 days ago"))
        feeds.add(Feed(R.drawable.profile6,R.drawable.fon6,"Gelsin Hayat Bildiği Gibi - 9.Bölüm","Gelsin Hayat","4M 573k views","2:20:04","3 days ago"))
        return feeds
    }
    fun getShorts(): ArrayList<ShortsModel> {
        val shorts: ArrayList<ShortsModel> = ArrayList<ShortsModel>()
        shorts.add(ShortsModel(R.drawable.short1, "Real or Fake", "872k views"))
        shorts.add(ShortsModel(R.drawable.short2,"Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"))
        shorts.add(ShortsModel(R.drawable.short3, "Hünkârbeğendi \uD83D\uDE0D", "1.5k views"))
        shorts.add(ShortsModel(R.drawable.short1, "Real or Fake", "872k views"))
        shorts.add(ShortsModel(R.drawable.short2, "Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"))
        shorts.add(ShortsModel(R.drawable.short3, "Hünkârbeğendi \uD83D\uDE0D", "1.5k views"))
        shorts.add(ShortsModel(R.drawable.short2,"Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"))
        shorts.add(ShortsModel(R.drawable.short3, "Hünkârbeğendi \uD83D\uDE0D", "1.5k views"))
        return shorts
    }
}