package kr.hs.entrydsm.exit.global.error.response

data class BindErrorResponse(
    val status: Int,
    val fieldError: List<Map<String, String?>>
)
