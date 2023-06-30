package com.car.app.modules

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val query = "CREATE TABLE car(name VARCHAR(10) PRIMARY KEY, model TEXT, manc TEXT, year TEXT)"
        sqLiteDatabase.execSQL(query)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users")
        onCreate(sqLiteDatabase)
    }

    fun carDetails(name: String?, model: String?, manc: String?, year: String): Boolean {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        return try {
            contentValues.put("name", name)
            contentValues.put("model", model)
            contentValues.put("manc", manc)
            contentValues.put("year", year.toInt())
            sqLiteDatabase.insert("car", null, contentValues)
            true
        } catch (e: Exception) {
            println(e.message)
            false
        } finally {
            sqLiteDatabase.close()
        }
    }

    val car: String?
        get() {
            val sqLiteDatabase = this.readableDatabase
            val res = StringBuilder()
            return try {
                val cursor = sqLiteDatabase.query("car", null, null, null, null, null, null)
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        res.append("[").append(
                            cursor.getString(cursor.getColumnIndexOrThrow("name")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("model")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("manc")) + ", " +
                                    cursor.getInt(cursor.getColumnIndexOrThrow("year"))
                        ).append("]").append("\n")
                    }
                    cursor.close()
                }
                res.toString()
            } catch (e: Exception) {
                println(e.message)
                null
            } finally {
                sqLiteDatabase.close()
            }
        }

    fun deleteCar(id: String) {
        val sqLiteDatabase = this.writableDatabase
        val res = sqLiteDatabase.delete("car", "name = ?", arrayOf(id))
        sqLiteDatabase.close()
    }

    fun update(name: String, model: String?, manc: String?, year: String) {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name", name)
        contentValues.put("model", model)
        contentValues.put("manc", manc)
        contentValues.put("year", year.toInt())
        val res = sqLiteDatabase.update("car", contentValues, "name = ?", arrayOf(name))
    }

    companion object {
        private const val DB_NAME = "car"
        private const val DB_VER = 1
    }
}
