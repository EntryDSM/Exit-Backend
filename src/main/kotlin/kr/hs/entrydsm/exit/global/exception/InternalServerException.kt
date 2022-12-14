package kr.hs.entrydsm.exit.global.exception

import kr.hs.entrydsm.exit.global.error.GlobalErrorCode
import kr.hs.entrydsm.exit.global.error.custom.GlobalCustomException

object InternalServerException: GlobalCustomException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)