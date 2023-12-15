package francisco.illa.ejemploretrofit.conexiones;

import java.util.ArrayList;

import francisco.illa.ejemploretrofit.modelos.Album;
import francisco.illa.ejemploretrofit.modelos.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIConexiones {
    @GET("/albums")
    Call<ArrayList<Album>>getAlbums();
    @GET("/photos?")
    Call<ArrayList<Photo>> getPhotoAlbum(@Query("albumId") int albumId);
}
