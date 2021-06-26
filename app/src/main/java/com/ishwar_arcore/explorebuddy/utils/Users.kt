package com.ishwar_arcore.explorebuddy.utils

class Users {
    var userId: String? = null
    var profilePic: String? = null
    var userName: String? = null
    var sex: String? = null
    var age: String? = null
    var addressone: String? = null
    var addresstwo: String? = null
    var city: String? = null
    var state: String? = null
    var pincode: String? = null
    var mobile: String? = null

    constructor() {}
    constructor(
        userId: String?,
        profilePic: String?,
        userName: String?,
        sex: String?,
        age: String?,
        addressone: String?,
        addresstwo: String?,
        city: String?,
        state: String?,
        pincode: String?,
        mobile: String?
    ) {
        this.userId = userId
        this.profilePic = profilePic
        this.userName = userName
        this.sex = sex
        this.age = age
        this.addressone = addressone
        this.addresstwo = addresstwo
        this.city = city
        this.state = state
        this.pincode = pincode
        this.mobile = mobile
    }


}