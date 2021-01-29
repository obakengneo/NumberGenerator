package com.obakengneo.numbergenerator.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.obakengneo.numbergenerator.model.Team

const val DATABASE_NAME = "MyDB"
const val TABLE_NAME = "Team"
const val COL_NAME = "name"
const val COL_LIST = "hymn"

class DataBaseHandler(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME, null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLE_NAME ($COL_NAME VARCHAR(50), $COL_LIST VARCHAR(1000))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val createTable = "DROP TABLE IF EXISTS $TABLE_NAME"

        db?.execSQL(createTable)
        onCreate(db)
    }

    fun getList(name: String): MutableList<Team> {
        val db = this.readableDatabase

        val query: String = if (name == "") {
            "Select * from $TABLE_NAME"
        } else {
            "Select * from $TABLE_NAME where $COL_NAME ='$name'"
        }

        val result = db.rawQuery(query, null)
        val list: MutableList<Team> = ArrayList()

        if (result.moveToFirst()) {
            do {
                val team = Team()

                team.name = result.getString(result.getColumnIndex(COL_NAME))
                team.teamList = result.getString(result.getColumnIndex(COL_LIST))

                list.add(team)
            } while (result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }

    fun deleteList(title: String) {
        val database = this.writableDatabase

        database.execSQL("DELETE FROM $TABLE_NAME WHERE $COL_NAME= '$title'")
        database.close()
    }

    fun insertTeam(team: Team) {
        val getName = getList(team.name)

        for (x in getName) {
            if (x.name == team.name) {
                deleteList(team.name)
            }
        }

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COL_NAME, team.name)
        cv.put(COL_LIST, team.teamList)

        db.insert(TABLE_NAME, null, cv)
        db.close()
    }
}

