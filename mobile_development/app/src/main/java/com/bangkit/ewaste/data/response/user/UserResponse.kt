package com.bangkit.ewaste.data.response.user

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("role")
	val role: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("jml_point")
	val jmlPoint: Int,

	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("email")
	val email: String
)
