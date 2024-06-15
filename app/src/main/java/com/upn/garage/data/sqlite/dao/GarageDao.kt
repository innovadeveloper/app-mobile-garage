package com.upn.garage.data.sqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.upn.garage.data.sqlite.GarageDBHelper
import com.upn.garage.domain.dto.GarageEntity

class GarageDao(context: Context) {

    private val dbHelper: GarageDBHelper = GarageDBHelper(context)

    fun insertGarageEntity(garageEntity: GarageEntity): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(GarageDBHelper.COLUMN_USERNAME, garageEntity.username)
            put(GarageDBHelper.COLUMN_POSITION, garageEntity.position)
            put(GarageDBHelper.COLUMN_STATE, garageEntity.state)
        }

        return db.insert(GarageDBHelper.TABLE_TB_GARAGE, null, values)
    }

    fun insertGarageEntitys(lugaresEstacionamiento: List<GarageEntity>): List<Long> {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val rowIds = mutableListOf<Long>()

        db.beginTransaction()
        try {
            for (lugarEstacionamiento in lugaresEstacionamiento) {
                val values = ContentValues().apply {
                    put(GarageDBHelper.COLUMN_USERNAME, lugarEstacionamiento.username)
                    put(GarageDBHelper.COLUMN_POSITION, lugarEstacionamiento.position)
                    put(GarageDBHelper.COLUMN_STATE, lugarEstacionamiento.state)
                }
                val newRowId = db.insert(GarageDBHelper.TABLE_TB_GARAGE, null, values)
                if (newRowId != -1L) {
                    rowIds.add(newRowId)
                }
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }

        return rowIds
    }

    fun garageEntitiesList(): List<GarageEntity> {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val garageEntitiesList = mutableListOf<GarageEntity>()

        val cursor: Cursor = db.query(
            GarageDBHelper.TABLE_TB_GARAGE, // The table to query
            null, // The columns to return
            null, // The columns for the WHERE clause
            null, // The values for the WHERE clause
            null, // Don't group the rows
            null, // Don't filter by row groups
            null // The sort order
        )

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(GarageDBHelper.COLUMN_ID))
                val username = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_USERNAME))
                val position = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_POSITION))
                val state = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_STATE))

                val garageEntity = GarageEntity(id, username, position, state)
                garageEntitiesList.add(garageEntity)
            }
            close()
        }

        return garageEntitiesList
    }
}