package com.upn.garage.data.sqlite


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GarageDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "GarageDB.db"
        const val DATABASE_VERSION = 1

        const val TABLE_TB_GARAGE = "TbGarage"
        const val COLUMN_ID = "id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_POSITION = "position"
        const val COLUMN_STATE = "state"


        const val TABLE_SESSION = "Session"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_CREATED_AT = "createdAt"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTbLugarEstacionamientoTable = """
            CREATE TABLE $TABLE_TB_GARAGE (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USERNAME TEXT NOT NULL,
                $COLUMN_POSITION TEXT NOT NULL,
                $COLUMN_STATE TEXT NOT NULL
            );
        """
        db.execSQL(createTbLugarEstacionamientoTable)

        val createSessionTable = """
            CREATE TABLE $TABLE_SESSION (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USERNAME TEXT NOT NULL,
                $COLUMN_PASSWORD TEXT NOT NULL,
                $COLUMN_CREATED_AT TEXT NOT NULL,
                $COLUMN_STATE TEXT NOT NULL
            );
        """
        db.execSQL(createSessionTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_TB_GARAGE")
        onCreate(db)
    }
}