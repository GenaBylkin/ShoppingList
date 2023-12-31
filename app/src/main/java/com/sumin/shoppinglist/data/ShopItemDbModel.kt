package com.sumin.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sumin.shoppinglist.domain.ShopItem
@Entity(tableName = "shop_item")
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int ,
    val name: String,
    val count: Int,
    val enabled: Boolean,
)
