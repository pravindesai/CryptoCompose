package com.pravin.cryptocompose.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(

	@field:SerializedName("followers")
	val followers: Int? = null,

	@field:SerializedName("contributors")
	val contributors: Int? = null,

	@field:SerializedName("stars")
	val stars: Int? = null,

	@field:SerializedName("subscribers")
	val subscribers: Int? = null
) : Parcelable