package br.com.andersonchoren.login.repository

import android.content.ContentValues
import android.content.Context
import br.com.andersonchoren.login.model.User
import br.com.andersonchoren.login.model.UserDAO

class UserRepository(context: Context) {
    companion object {
        private val table = "users"
    }

    val db = UserDAO(context).writableDatabase

    // Métodos do CRUD
    fun insert(user: User): Long {
        val contentValues = ContentValues().apply {
            put("email", user.email)
            put("password", user.password)
        }
        return db.insert(table, "", contentValues)
    }

    fun findOne(user: User): User? {
        val cursor =
            db.query(
                table,
                arrayOf("id"),
                "email = ? and password = ?",
                arrayOf(user.email, user.password),
                null,
                null,
                null
            )
        val result = cursor.moveToFirst()
        if (!result) {
            return null
        }
        val id = cursor.getLong(0)
        cursor.close()
        return User(id, user.email, user.password)
    }
}