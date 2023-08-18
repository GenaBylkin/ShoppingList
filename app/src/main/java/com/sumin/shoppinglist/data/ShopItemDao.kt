package com.sumin.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ShopItemDao {


    @Query("SELECT * FROM shop_item")
    fun getShopList() :LiveData<List<ShopItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_item WHERE id=:shopItemId")
    suspend fun deleteShopItem(shopItemId: Int)

    @Query("SELECT * FROM shop_item WHERE id=:shopItemId")
    suspend fun getShopItem(shopItemId: Int): ShopItemDbModel

}