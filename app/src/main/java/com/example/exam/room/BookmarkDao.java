package com.example.exam.room;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.exam.entity.Bookmark;

import java.util.List;

public interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBookmark(Bookmark bookmark);

    @Update
    void updateBookmark(Bookmark bookmark);

    @Query("DELETE FROM Bookmark WHERE id = :id")
    void deleteBookmark(int id);

    @Query("SELECT * FROM Bookmark")
    List<Bookmark> findAll();

    @Query("SELECT * FROM Bookmark WHERE id = :id")
    Bookmark findById(int id);

    @Query("DELETE FROM Bookmark")
    void deleteAll();
}
