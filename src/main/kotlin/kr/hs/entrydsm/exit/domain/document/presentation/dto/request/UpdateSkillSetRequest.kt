package kr.hs.entrydsm.exit.domain.document.presentation.dto.request

import org.jetbrains.annotations.NotNull

data class UpdateSkillSetRequest (

    @field:NotNull
    val skillList: List<String>
)