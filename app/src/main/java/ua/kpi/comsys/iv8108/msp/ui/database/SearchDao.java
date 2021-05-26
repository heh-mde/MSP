package ua.kpi.comsys.iv8108.msp.ui.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ua.kpi.comsys.iv8108.msp.ui.books.SearchTable;

@Dao
public interface SearchDao {
    @Query("SELECT * FROM searchtable")
    List<SearchTable> getAll();

    @Query("SELECT * FROM searchtable WHERE id = :id")
    SearchTable getById(long id);

    @Query("SELECT * FROM searchtable WHERE searchQueue = :query ORDER BY id DESC LIMIT 1")
    SearchTable getLastByQuery(String query);

    @Query("SELECT * FROM searchtable ORDER BY id DESC LIMIT 1")
    SearchTable getLastSearch();

    @Insert
    void insert(SearchTable searchTable);

    @Update
    void update(SearchTable searchTable);

    @Delete
    void delete(SearchTable searchTable);
}
