package br.com.paulosalvatore.pagseguro_android_turmab.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.paulosalvatore.pagseguro_android_turmab.entities.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: Word)

    @Update
    fun update(word: Word)

    @Delete
    fun delete(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}
