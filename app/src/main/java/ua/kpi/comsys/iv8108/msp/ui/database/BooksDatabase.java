package ua.kpi.comsys.iv8108.msp.ui.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ua.kpi.comsys.iv8108.msp.ui.books.MainTable;
import ua.kpi.comsys.iv8108.msp.ui.books.SearchTable;
import ua.kpi.comsys.iv8108.msp.ui.gallery.ImageDao;
import ua.kpi.comsys.iv8108.msp.ui.gallery.ImagesEntity;

@Database(entities = {MainTable.class, SearchTable.class, ImagesEntity.class}, version = 3)
public abstract class BooksDatabase extends RoomDatabase {
    public abstract MainDao bookDao();
    public abstract SearchDao searchTableDao();
    public abstract ImageDao galleryDao();
}
