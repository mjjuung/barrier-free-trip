package com.triply.barrierfreetrip.data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class LoginDto(
    val accessToken: String,
    val email: String,
    val nickname: String,
    val refreshToken: String
)

data class TourFacilityDetail(
    val addr1: String,
    val addr2: String,
    val areaCode: String,
    val braileblock: String?,
    val checkInTime: String,
    val checkOutTime: String,
    val contentId: String,
    val contentTypeId: String,
    val elevator: String?,
    val freeParking: String?,
    val handicapetc: String?,
    val homepage: String,
    val imgs: List<String>,
    val like: Int, // 0 -> 찜X | 1 -> 찜O
    val mapx: String,
    val mapy: String,
    val overview: String,
    val publictransport: String?,
    val rating: String,
    val restroom: String?,
    val sigunguCode: Any,
    val tel: String,
    val title: String,
)

data class Charger(
    val addr: String,
    val contentId: Int,
    val like: Int,
    val tel: String,
    val title: String
)

data class ChargerDetail(
    val addr: String,
    val air: String,
    val holidayClose: String,
    val holidayOpen: String,
    val like: Int,
    val phoneCharge: String,
    val possible: String,
    val tel: String,
    val title: String,
    val weekdayClose: String,
    val weekdayOpen: String,
    val weekendClose: String,
    val weekendOpen: String
)

data class CareTour(

    val addr: String,
    val like: Int,
    val tel: String,
    val title: String
)

data class RentalServicePlace(
    val addr: String,
    val like: Int,
    val tel: String,
    val title: String
)

data class SearchRsltItem(
    val addr: String,
    val firstImage: String,
    val rating: String,
    val tel: String,
    val title: String,
    val type: Int,
    val id: Int,
    val like: Boolean
)

data class RestPlace(
    val addr: String,
    val contentId: String,
    val contentTypeId: String,
    val firstimg: String,
    val rating: Any,
    val title: String
)

data class InfoListDto(
    val id: Int,
    val addr: String,
    val like: Boolean,
    val tel: String,
    val title: String
)

data class InfoSquareDto(
    val addr: String,
    val contentId: String,
    val contentTypeId: String,
    val firstimg: String,
    val like: Boolean,
    val rating: String,
    val tel: String,
    val title: String
) {
    object SquareBind {
        @JvmStatic
        @BindingAdapter("setImage")
        fun setImgUrl(view: ImageView, img: String) {
            Glide.with(view.context)
                .load(img)
                .into(view)
        }
    }
}

data class Sido (
    val code: String,
    val name: String
)

data class Sigungu (
    val code: String,
    val name: String
)

data class ReviewListDTO(
    val totalCnt: Int,
    val reviews: List<ReviewDTO>
) {
    data class ReviewDTO(
        val nickname: String,
        val rating: Double,
        val content: String,
        val createdDate: String
    )
}

data class ReviewRegistrationDTO(
    val rating: Double,
    val content: String
)

data class ConvenienceInfoDTO(
    val subject: String,
    val content: String
)