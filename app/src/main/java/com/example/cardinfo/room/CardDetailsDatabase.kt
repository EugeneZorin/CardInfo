package com.example.cardinfo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cardinfo.data.constant.ConstantValue.CARD_DATABASE
import kotlinx.coroutines.flow.Flow

@Database(entities = [CardDetails::class], version = 1)
abstract class CardDetailsDatabase: RoomDatabase() {

    abstract fun cardDetailsDao(): CardDetailsDao

    companion object {

        @Volatile
        private var INSTANCE: CardDetailsDatabase? = null

        fun getDatabase(context: Context): CardDetailsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardDetailsDatabase::class.java,
                    CARD_DATABASE
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}