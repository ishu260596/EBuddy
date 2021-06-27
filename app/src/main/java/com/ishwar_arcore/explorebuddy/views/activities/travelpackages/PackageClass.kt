package com.ishwar_arcore.explorebuddy.views.activities.travelpackages

import java.io.Serializable

data class PackageClass(
    var hotel: String, var place: String, var cost: String, var nights: String
) : Serializable {


//    constructor() {
//
//    }
//
//    constructor(hotel: String?, place: String?, cost: String?, nights: String?) {
//        this.hotel = hotel
//        this.cost = cost
//        this.place = place
//        this.nights = nights
//    }


}