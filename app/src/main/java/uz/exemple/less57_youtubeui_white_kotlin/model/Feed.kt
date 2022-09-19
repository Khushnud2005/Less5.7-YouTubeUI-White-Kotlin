package uz.exemple.less57_youtubeui_white_kotlin.model

class Feed{
    var profile:Int= 0
    var photo:Int = 0
    var title:String
    lateinit var channel:String
    lateinit var count_views:String
    lateinit var time:String
    lateinit var created:String
    var shortsList: ArrayList<ShortsModel>?= null

    constructor(title: String,shortsList: ArrayList<ShortsModel>){
        this.title = title
        this.shortsList = shortsList
    }

    constructor(profile:Int,photo:Int,title:String,channel:String,count_views:String, time:String, created:String){
        this.profile = profile
        this.photo = photo
        this.title = title
        this.channel = channel
        this.count_views = count_views
        this.time = time
        this.created = created
    }

}