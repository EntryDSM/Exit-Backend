package kr.hs.entrydsm.exit.global.exception.jwt

import kr.hs.entrydsm.exit.global.error.GlobalErrorCode
import kr.hs.entrydsm.exit.global.error.custom.GlobalCustomException

object ExpiredTokenException: GlobalCustomException(
    GlobalErrorCode.EXPIRED_JWT
)