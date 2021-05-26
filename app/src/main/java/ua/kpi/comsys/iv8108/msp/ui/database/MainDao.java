package ua.kpi.comsys.iv8108.msp.ui.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ua.kpi.comsys.iv8108.msp.ui.books.MainTable;

@Dao
public interface MainDao {
    @Query("UPDATE MainTable " +
            "SET authors = :authors, description = :desc, pages = :pages, " +
            "publisher = :publisher, rating = :rating, year = :year " +
            "WHERE isbn13 = :isbn13")
    void setInfoByIsbn13(long isbn13, String authors, String desc, long pages, String publisher, String rating, long year);

    @Query("SELECT * FROM MainTable")
    List<MainTable> getAll();

    @Query("SELECT * FROM MainTable WHERE isbn13 = :isbn13")
    MainTable getByIsbn13(long isbn13);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MainTable mainTable);

    @Update
    void update(MainTable mainTable);

    @Delete
    void delete(MainTable mainTable);
}
