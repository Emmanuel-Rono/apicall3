package NetworkLayer

import NetworkLayer.constants.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Acces Moshi will be used to convert json files
private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
//Add converter the Moshi converter factory
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
//Create interface for the api
interface GetDataFromCloud
{
    @GET("/photos")
    private fun getPhotos():List<PhotoResponse>

}

object MarsApi
{
    val retrofitservice:GetDataFromCloud by lazy {
        retrofit.create(GetDataFromCloud::class.java)
    }
}