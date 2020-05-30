package com.whiterabbit.test.db

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "person_info")
class UserListItem {

    @ColumnInfo(name = "id")
    private val id: String? = null

    @ColumnInfo(name = "name")
    private val name: String? = null

    @ColumnInfo(name = "username")
    private val username: String? = null

    @ColumnInfo(name = "email")
    private val email: String? = null

    @ColumnInfo(name = "profile_image")
    private val profile_image: String? = null

}