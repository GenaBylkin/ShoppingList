package com.sumin.shoppinglist.data

import com.sumin.shoppinglist.domain.ShopItem

class ShopListMapper {

    fun mapShopListToShopListDb(shopItem: ShopItem) :ShopItemDbModel {
        return ShopItemDbModel(
            shopItem.id,
            shopItem.name,
            shopItem.count,
            shopItem.enabled
        )
    }

    fun mapShopListDbToShopList(shopItemDbModel: ShopItemDbModel) :ShopItem {
        return ShopItem(
            shopItemDbModel.name,
            shopItemDbModel.count,
            shopItemDbModel.enabled,
            shopItemDbModel.id
        )
    }


    fun mapDbModelToList(list: List<ShopItemDbModel>) : List<ShopItem> {
       return list.map {
            mapShopListDbToShopList(it)
        }
    }

}