package br.com.andersonsilva.askeonbooks.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookDAO(context:Context) : SQLiteOpenHelper(context,db_name,null,db_version) {
    companion object{
        private val db_name = "AskOnBooksBook.db"
        private val db_version = 1
        private val table_name = "book"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // db.execSQL("CREATE TABLE book (id INTAGER PRIMARY KEY AUTOINCREMENT, name TEXT, image TEXT, author TEXT, genre TEXT, pages TEXT)")
        db.execSQL("CREATE TABLE $table_name (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,image TEXT, author TEXT, genre TEXT, pages TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if(oldVersion < newVersion){
            // db.execSQL("DROP TABLE book")
            db.execSQL("DROP TABLE $table_name")
            onCreate(db)
        }
    }
}