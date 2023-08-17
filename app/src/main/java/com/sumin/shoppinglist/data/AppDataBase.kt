package com.sumin.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {


    abstract fun shopListDao():ShopItemDao


    companion object {

        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val BASE_NAME = "shop_item.db"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }

            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    BASE_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }

    }

}