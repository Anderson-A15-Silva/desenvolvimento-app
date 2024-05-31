package br.com.andersonsilva.askeonbooks.repository

import android.content.ContentValues
import android.content.Context
import br.com.andersonsilva.askeonbooks.model.Book
import br.com.andersonsilva.askeonbooks.model.BookDAO

class BookRepository(context:Context) {
    companion object{
        private val table = "book"
    }
    val db = BookDAO(context).writableDatabase
    fun insert(book:Book): Long {
        val contentValues = ContentValues().apply {
            put("name",book.name)
            put("image",book.image)
            put("author",book.author)
            put("pages",book.pages)
            put("genrer",book.genrer)
        }
        return db.insert(table,"",contentValues)
    }

// meu pau
    fun findAll(book:Book): List<Book>? {
        return mutableListOf <Book> ().apply {
            val cursor = db.rawQuery("SELECT * FROM $table", null)
            while (cursor.moveToNext()){
                val id = cursor.getInt(0)
                val image = cursor.getString(1)
                val name = cursor.getString(2)
                val author = cursor.getString(3)
                val page = cursor.getString(4)
                val genrer = cursor.getString(5)
                add(Book(id, image,name, author,page, genrer))
            }
            // cursor.close()
            val result = cursor.moveToFirst()
            if (!result) {
                return null
            }
            val id = cursor.getLong(0)
            cursor.close()
        }
    }
}