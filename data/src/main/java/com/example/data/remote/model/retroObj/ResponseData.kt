package com.example.data.remote.model.retroObj

sealed class ResponseData {
    sealed class UserData {

        data class User(
            var _id: String = "",
            var first_name: String = "",
            var last_name: String = " ",
            var email_field: String = "",
            var phone_field: String = "",
            // var permissions: MutableList<Business.RoleFeature> = mutableListOf(),
            // var stores: MutableList<SharedResponse.NameAndId> = mutableListOf(),
            var payment_option: MutableList<String> = mutableListOf(),
            var name: String = "",
            // var online_catalog: BusinessSettings.OnlineCatalogData = BusinessSettings.OnlineCatalogData(),
        )

        data class UserResponse(var token: String = "", var user: User = User())
    }
}