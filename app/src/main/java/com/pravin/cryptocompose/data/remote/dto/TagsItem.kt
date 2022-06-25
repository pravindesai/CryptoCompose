package com.pravin.cryptocompose.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TagsItem(

	@field:SerializedName("coin_counter")
	val coinCounter: Int? = null,

	@field:SerializedName("ico_counter")
	val icoCounter: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable