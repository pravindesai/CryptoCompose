package com.pravin.cryptocompose.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoCoinDetails(

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("is_new")
	val isNew: Boolean? = null,

	@field:SerializedName("proof_type")
	val proofType: String? = null,

	@field:SerializedName("first_data_at")
	val firstDataAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("team")
	val team: List<TeamItem?>? = null,

	@field:SerializedName("links_extended")
	val linksExtended: List<LinksExtendedItem?>? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("tags")
	val tags: List<TagsItem?>? = null,

	@field:SerializedName("last_data_at")
	val lastDataAt: String? = null,

	@field:SerializedName("whitepaper")
	val whitepaper: Whitepaper? = null,

	@field:SerializedName("org_structure")
	val orgStructure: String? = null,

	@field:SerializedName("hardware_wallet")
	val hardwareWallet: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("development_status")
	val developmentStatus: String? = null,

	@field:SerializedName("hash_algorithm")
	val hashAlgorithm: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("started_at")
	val startedAt: String? = null,

	@field:SerializedName("links")
	val links: Links? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("open_source")
	val openSource: Boolean? = null
) : Parcelable