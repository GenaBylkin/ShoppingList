package com.sumin.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.sumin.shoppinglist.domain.ShopItem
import com.sumin.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

class ShopListRepositoryImpl(
    application: Application
) : ShopListRepository {

    private val shopListDao = AppDataBase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()
    //private val shopListLD = MutableLiveData<List<ShopItem>>()
   // private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapShopListToShopListDb(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapShopListToShopListDb(shopItem))
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        val db = shopListDao.getShopItem(shopItemId)
        return mapper.mapShopListDbToShopList(db)
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return Transformations.map(shopListDao.getShopList()) {
            mapper.mapDbModelToList(it)
        }
    }
}
