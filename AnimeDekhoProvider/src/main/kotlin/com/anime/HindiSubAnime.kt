package com.anime

import com.google.gson.Gson
import com.cosmix.api.Log
import com.cosmix.app.ErrorLoadingException
import com.cosmix.app.SubtitleFile
import com.cosmix.app.app
import com.cosmix.app.mainPageOf
import com.cosmix.app.utils.ExtractorLink
import com.cosmix.app.utils.loadExtractor

class HindiSubAnime : AnimeDekhoProvider() {
    override var mainUrl = "https://hindisubanime.co"
    override var name = "HindiSubAnime"
    override val hasMainPage = true
    override var lang = "hi"

    override val mainPage =
        mainPageOf(
            "/category/shounen/" to "Shounen",
            "/category/action/" to "Action",
            "/category/fantasy/" to "Fantasy",
            "/serie/" to "Series",
        )

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ): Boolean {
        val media = Gson().fromJson(data, Media::class.java)
        val body = app.get(media.url).document.selectFirst("body")?.attr("class") ?: return false
        val term = Regex("""(?:term|postid)-(\d+)""").find(body)?.groupValues?.get(1)
            ?: throw ErrorLoadingException("no id found")
        for (i in 0..4) {
            val link = app.get("$mainUrl/?trdekho=$i&trid=$term&trtype=${media.mediaType}")
                .document.selectFirst("iframe")?.attr("src")
                ?: throw ErrorLoadingException("no iframe found")
            Log.d("Phisher", link)
            loadExtractor(link, subtitleCallback, callback)
        }
        return true
    }
}
