package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import java.io.Serializable

class GModel : Serializable {
    private var id: String? = null
    var budget: String? = null
    private var place: String? = null
    private var plan: String? = null
    var prefer: String? = null
    private var travel: String? = null

    constructor() {}
    constructor(
        id: String?,
        budget: String?,
        place: String?,
        plan: String?,
        prefer: String?,
        travel: String?
    ) {
        this.id = id
        this.budget = budget
        this.place = place
        this.plan = plan
        this.prefer = prefer
        this.travel = travel
    }

}