package ua.kpi.comsys.iv8108.msp.ui.gallery;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ImageDao {
    @Query("SELECT * FROM ImagesEntity WHERE imageUrl = :url")
    ImagesEntity getByUrl(String url);

    @Query("UPDATE ImagesEntity SET imageData = :data WHERE imageUrl = :url")
    void setImageBitmapByUrl(String url, byte[] data);

    @Query("UPDATE ImagesEntity SET imageData = :data WHERE id = :id")
    void setImageBitmapById(long id, byte[] data);

    @Query("SELECT * FROM ImagesEntity")
    List<ImagesEntity> getAll();

    @Query("SELECT imageUrl FROM ImagesEntity")
    List<String> getAllUrls();

    @Query("SELECT id FROM ImagesEntity")
    List<Long> getAllIds();

    @Query("SELECT * FROM ImagesEntity WHERE id = :id")
    ImagesEntity getById(long id);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ImagesEntity imagesEntity);

    @Update
    void update(ImagesEntity imagesEntity);

    @Delete
    void delete(ImagesEntity imagesEntity);
}
