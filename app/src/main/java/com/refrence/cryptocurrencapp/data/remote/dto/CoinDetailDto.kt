package com.refrence.cryptocurrencapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.refrence.cryptocurrencapp.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    @SerializedName("development_status")
    val development_status: String,
    @SerializedName("first_data_at")
    val first_data_at: String,
    @SerializedName("hardware_wallet")

    val hardware_wallet: Boolean,
    @SerializedName("hash_algorithm")
    val hash_algorithm: String,
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    @SerializedName("last_data_at")
    val last_data_at: String,
    val links: Links,
    @SerializedName("links_extended")
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val open_source: Boolean,
    @SerializedName("org_structure")
    val org_structure: String,
    @SerializedName("proof_type")
    val proof_type: String,
    val rank: Int,
    @SerializedName("started_at")
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail{
    return CoinDetail(
         coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        is_active = is_active,
        tags = tags.map { it.name },
        team = team
    )
}

