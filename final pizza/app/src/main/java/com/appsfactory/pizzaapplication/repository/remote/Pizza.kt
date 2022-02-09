package com.appsfactory.pizzaapplication.repository.remote

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pizza_table")
data class Pizza(
    @ColumnInfo val name: String,
    @ColumnInfo val description: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable

