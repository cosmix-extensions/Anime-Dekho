package com.anime

import com.cosmix.app.plugins.CsxPlugin
import app.cosmix.plugins.CosmixPlugin
import com.cosmix.app.plugins.CsxPluginAnnotation
import com.cosmix.app.extractors.FileMoon
import com.cosmix.app.extractors.FilemoonV2
import com.cosmix.app.extractors.Krakenfiles
import com.cosmix.app.extractors.StreamTape
import com.cosmix.app.extractors.Voe

@CosmixPlugin
@CsxPluginAnnotation
class AnimeDekhoPlugin: CsxPlugin() {
    override fun load() {
        registerCsxApi(AnimeDekhoProvider())
        registerCsxApi(OnepaceProvider())
        registerCsxApi(HindiSubAnime())
        registerExtractorApi(StreamRuby())
        registerExtractorApi(Vidmolynet())
        registerExtractorApi(GDMirrorbot())
        registerExtractorApi(Techinmind())
        registerExtractorApi(Cdnwish())
        registerExtractorApi(Multimovies())
        registerExtractorApi(FileMoon())
        registerExtractorApi(FileMoonNL())
        registerExtractorApi(Krakenfiles())
        registerExtractorApi(Voe())
        registerExtractorApi(StreamTape())
        registerExtractorApi(FilemoonV2())
        registerExtractorApi(Animezia())
        registerExtractorApi(Cloudy())
        registerExtractorApi(vidcloudupns())
        registerExtractorApi(Animedekhoco())
        registerExtractorApi(Blakiteapi())
        registerExtractorApi(ascdn21())
        registerExtractorApi(Abyass())
    }
}
