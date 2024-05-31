package br.com.andersonchoren.login.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDAO(context: Context) : SQLiteOpenHelper(context, db_name, null, db_version) {
    companion object {
        private val db_name = "users.db"
        private val db_version = 1
        private val table_name = "users"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $table_name (id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT)")
        // Demais comandos SQL
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE $table_name")
            onCreate(db)
        }
    }
}