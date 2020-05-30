package com.whiterabbit.test.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person_info")
data class Response(

    @ColumnInfo(name = "profile_image")
    @field:SerializedName("profile_image")
    val profileImage: String? = null,

    @ColumnInfo(name = "website")
    @field:SerializedName("website")
    val website: String? = null,

    @ColumnInfo(name = "address")
    @field:SerializedName("address")
    val address: Address? = null,

    @ColumnInfo(name = "phone")
    @field:SerializedName("phone")
    val phone: Any? = null,

    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name: String? = null,

    @ColumnInfo(name = "company")
    @field:SerializedName("company")
    val company: Company? = null,

    @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: Int? = null,

    @ColumnInfo(name = "email")
    @field:SerializedName("email")
    val email: String? = null,

    @ColumnInfo(name = "username")
    @field:SerializedName("username")
    val username: String? = null
)