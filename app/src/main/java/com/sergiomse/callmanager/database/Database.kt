package com.sergiomse.callmanager.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


/**
 * Created by sergiomse@gmail.com on 15/12/2017.
 */

class Database {

    private val DATABASE_NAME = "database.db"
    val DATABASE_TABLE = "phones"
    val DATABASE_VERSION = 1

    val COLS = arrayOf("_id", "number")


    /**
     *
     */
    inner private class DBOpenHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        private val TAG = DBOpenHelper::class.java.name

        private val CREATE_TABLE = "create table " +
                DATABASE_TABLE + " (" +
                "_id integer primary key autoincrement, " +
                "number text);"

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(CREATE_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            Log.d(TAG, "Database upgrade")
        }
    }


    private var helper: DBOpenHelper? = null
    private var db: SQLiteDatabase? = null

    fun Database(context: Context) {
        helper = DBOpenHelper(context)
        establishDb()
    }

    fun establishDb() {
        if (db == null) {
            db = helper!!.writableDatabase
        }
    }

    fun cleanup() {
        if (db != null) {
            db!!.close()
            db = null
        }
    }

}