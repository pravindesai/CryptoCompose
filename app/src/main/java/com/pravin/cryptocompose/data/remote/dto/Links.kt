package com.pravin.cryptocompose.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(

	@field:SerializedName("youtube")
	val youtube: List<String?>? = null,

	@field:SerializedName("website")
	val website: List<String?>? = null,

	@field:SerializedName("facebook")
	val facebook: List<String?>? = null,

	@field:SerializedName("explorer")
	val explorer: List<String?>? = null,

	@field:SerializedName("reddit")
	val reddit: List<String?>? = null,

	@field:SerializedName("source_code")
	val sourceCode: List<String?>? = null
) : Parcelable