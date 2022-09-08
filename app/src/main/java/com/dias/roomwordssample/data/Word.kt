package com.dias.roomwordssample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    /**
     * Tip on auto-generating keys: To auto-generate a unique key for each entity,
     * you would add and annotate a primary integer key with autoGenerate=true.
     */
    @PrimaryKey @ColumnInfo(name = "word") val word: String,
)