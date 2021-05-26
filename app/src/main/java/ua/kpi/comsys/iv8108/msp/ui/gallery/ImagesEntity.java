package ua.kpi.comsys.iv8108.msp.ui.gallery;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

@Entity
public class ImagesEntity {
    @PrimaryKey
    public long id;
    public String imageUrl;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] imageData;

    public ImagesEntity(long id, String imageUrl, byte[] imageData){
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageData = imageData;
    }

    public Bitmap getBitmapImage(Context context) throws ExecutionException, InterruptedException {
        return Glide.with(context).asBitmap().load(imageData).submit().get();
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }
}
