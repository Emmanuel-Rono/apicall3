package NetworkLayer

import com.squareup.moshi.Json

class PhotoResponse (
val id :String,
    @Json(name = "img_src") val imgSrcUrl: String

    )
