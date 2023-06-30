package com.car.app.modules.registerpage.ui

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.EditText


class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val query = "CREATE TABLE users(id VARCHAR(10) PRIMARY KEY, fname TEXT, lname TEXT, email TEXT, pwd TEXT, house TEXT, city TEXT, state TEXT, pin TEXT)"
        sqLiteDatabase.execSQL(query)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users")
        onCreate(sqLiteDatabase)
    }

    fun registerUser(mob: String?, fname: String?,lname:String?, email: String?,pwd:String?,house:String?,city:String?,state:String?,pin:String?): Boolean {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        try {
            contentValues.put("id", mob)
            contentValues.put("fname", fname)
            contentValues.put("lname", lname)
            contentValues.put("email", email)
            contentValues.put("pwd", pwd)
            contentValues.put("house", house)
            contentValues.put("city", city)
            contentValues.put("state", state)
            contentValues.put("pin", pin)
            sqLiteDatabase.insert("users", null, contentValues)
            return true
        } catch (e: Exception) {
            println(e.message)
            return false
        } finally {
            sqLiteDatabase.close()
        }
    }

    val users: String?
        get() {
            val sqLiteDatabase = this.readableDatabase
            val res = StringBuilder()
            try {
                val cursor = sqLiteDatabase.query("users", null, null, null, null, null, null)
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        res.append("[").append(
                            cursor.getString(cursor.getColumnIndexOrThrow("id")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("fname")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("lname")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("email")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("pwd")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("house")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("city")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("state")) + ", " +
                                    cursor.getInt(cursor.getColumnIndexOrThrow("pin"))
                        ).append("]").append("\n")
                    }
                    cursor.close()
                }
                return res.toString()
            } catch (e: Exception) {
                println(e.message)
                return null
            } finally {
                sqLiteDatabase.close()
            }
        }

    fun deleteUser(id: String) {
        val sqLiteDatabase = this.writableDatabase
        val res = sqLiteDatabase.delete("users", "id = ?", arrayOf(id))
        sqLiteDatabase.close()
    }

    fun update(
        id: EditText, fname: EditText,
        lname: EditText, email: EditText,
        pwd: EditText,
        house: EditText,
        city: EditText,
        state: EditText,
        pin: EditText
    ) {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", id.text.toString())
        contentValues.put("name", fname.text.toString())
        contentValues.put("lname", lname.text.toString())
        contentValues.put("email", email.text.toString())
        contentValues.put("pwd", pwd.text.toString())
        contentValues.put("house", house.text.toString())
        contentValues.put("city", city.text.toString())
        contentValues.put("state", state.text.toString())
        contentValues.put("pin", pin.text.toString())
        val res = sqLiteDatabase.update("users", contentValues, "id = ?", arrayOf(id.text.toString()))
    }

    companion object {
        private val DB_NAME = "users"
        private val DB_VER = 1
    }
}
