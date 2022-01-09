package com.example.roomandrecycleview.db2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//This code is optmizable
@Database(entities = [UserEntity2::class], version = 2)
abstract class RoomAppDb2: RoomDatabase() {

    abstract fun userDao(): UserDao2?

    companion object {
        private var INSTANCE: RoomAppDb2?= null

        val migration_1_2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE userinfo ADD COLUMN phone TEXT DEFAULT ''")
            }
        }

        fun getAppDatabase(context: Context): RoomAppDb2? {

            if(INSTANCE == null ) {

                INSTANCE = Room.databaseBuilder<RoomAppDb2>(
                    context.applicationContext, RoomAppDb2::class.java, "AppDBB2"
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}