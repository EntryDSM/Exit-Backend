package kr.hs.entrydsm.exit.domain.document.persistence.element

import java.util.*

class AwardElement(

    val name: String,
    val awardingInstitution: String,
    val date: Date,
    val description: String?,
    val url: String?

)