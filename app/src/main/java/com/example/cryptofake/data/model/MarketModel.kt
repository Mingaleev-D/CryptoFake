package com.example.cryptofake.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MarketModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: Status
) {
    @Keep
    data class Data(
        @SerializedName("cryptoCurrencyList")
        val cryptoCurrencyList: List<CryptoCurrency>,
        @SerializedName("totalCount")
        val totalCount: String
    ) {
        @Keep
        data class CryptoCurrency(
            @SerializedName("auditInfoList")
            val auditInfoList: List<AuditInfo>?,
            @SerializedName("circulatingSupply")
            val circulatingSupply: Double,
            @SerializedName("cmcRank")
            val cmcRank: Int,
            @SerializedName("dateAdded")
            val dateAdded: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("isActive")
            val isActive: Int,
            @SerializedName("isAudited")
            val isAudited: Boolean,
            @SerializedName("lastUpdated")
            val lastUpdated: String,
            @SerializedName("marketPairCount")
            val marketPairCount: Int,
            @SerializedName("maxSupply")
            val maxSupply: Long?,
            @SerializedName("name")
            val name: String,
            @SerializedName("platform")
            val platform: Platform?,
            @SerializedName("quotes")
            val quotes: List<Quote>,
            @SerializedName("selfReportedCirculatingSupply")
            val selfReportedCirculatingSupply: Double,
            @SerializedName("slug")
            val slug: String,
            @SerializedName("symbol")
            val symbol: String,
            @SerializedName("tags")
            val tags: List<String>,
            @SerializedName("totalSupply")
            val totalSupply: Double
        ) {
            @Keep
            data class AuditInfo(
                @SerializedName("auditStatus")
                val auditStatus: Int,
                @SerializedName("auditTime")
                val auditTime: String?,
                @SerializedName("auditor")
                val auditor: String,
                @SerializedName("coinId")
                val coinId: String,
                @SerializedName("contractAddress")
                val contractAddress: String?,
                @SerializedName("contractPlatform")
                val contractPlatform: String?,
                @SerializedName("reportUrl")
                val reportUrl: String?,
                @SerializedName("score")
                val score: String?
            )

            @Keep
            data class Platform(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("slug")
                val slug: String,
                @SerializedName("symbol")
                val symbol: String,
                @SerializedName("token_address")
                val tokenAddress: String
            )

            @Keep
            data class Quote(
                @SerializedName("dominance")
                val dominance: Double,
                @SerializedName("fullyDilluttedMarketCap")
                val fullyDilluttedMarketCap: Double,
                @SerializedName("lastUpdated")
                val lastUpdated: String,
                @SerializedName("marketCap")
                val marketCap: Double,
                @SerializedName("marketCapByTotalSupply")
                val marketCapByTotalSupply: Double,
                @SerializedName("name")
                val name: String,
                @SerializedName("percentChange1h")
                val percentChange1h: Double,
                @SerializedName("percentChange24h")
                val percentChange24h: Double,
                @SerializedName("percentChange30d")
                val percentChange30d: Double,
                @SerializedName("percentChange60d")
                val percentChange60d: Double,
                @SerializedName("percentChange7d")
                val percentChange7d: Double,
                @SerializedName("percentChange90d")
                val percentChange90d: Double,
                @SerializedName("price")
                val price: Double,
                @SerializedName("turnover")
                val turnover: Double,
                @SerializedName("tvl")
                val tvl: Double?,
                @SerializedName("volume24h")
                val volume24h: Double,
                @SerializedName("ytdPriceChangePercentage")
                val ytdPriceChangePercentage: Double
            )
        }
    }

    @Keep
    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int,
        @SerializedName("elapsed")
        val elapsed: String,
        @SerializedName("error_code")
        val errorCode: String,
        @SerializedName("error_message")
        val errorMessage: String,
        @SerializedName("timestamp")
        val timestamp: String
    )
}