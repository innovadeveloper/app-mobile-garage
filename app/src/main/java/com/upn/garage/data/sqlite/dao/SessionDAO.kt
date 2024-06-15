package com.upn.garage.data.sqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.upn.garage.data.sqlite.GarageDBHelper
import com.upn.garage.domain.dto.SessionEntity

class SessionDAO(context: Context) {

    private val dbHelper: GarageDBHelper = GarageDBHelper(context)

    fun insertSessionEntity(session: SessionEntity): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(GarageDBHelper.COLUMN_USERNAME, session.username)
            put(GarageDBHelper.COLUMN_PASSWORD, session.password)
            put(GarageDBHelper.COLUMN_CREATED_AT, session.createdAt)
            put(GarageDBHelper.COLUMN_STATE, session.state)
        }

        return db.insert(GarageDBHelper.TABLE_SESSION, null, values)
    }

    fun getAllSessionEntitys(): List<SessionEntity> {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val sessions = mutableListOf<SessionEntity>()

        val cursor: Cursor = db.query(
            GarageDBHelper.TABLE_SESSION, // The table to query
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
                val password = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_PASSWORD))
                val createdAt = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_CREATED_AT))
                val state = getString(getColumnIndexOrThrow(GarageDBHelper.COLUMN_STATE))

                val session = SessionEntity(id, username, password, createdAt, state)
                sessions.add(session)
            }
            close()
        }

        return sessions
    }

    fun updateSessionEntityState(sessionId: Int, newState: String): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(GarageDBHelper.COLUMN_STATE, newState)
        }

        val selection = "${GarageDBHelper.COLUMN_ID} = ?"
        val selectionArgs = arrayOf(sessionId.toString())

        return db.update(
            GarageDBHelper.TABLE_SESSION,
            values,
            selection,
            selectionArgs
        )
    }
}