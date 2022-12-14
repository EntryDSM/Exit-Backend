package kr.hs.entrydsm.exit.global.security.jwt


import kr.hs.entrydsm.exit.global.security.jwt.properties.JwtConstants
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val token = resolvedToken(request)
        SecurityContextHolder.clearContext()

        token?.let{
            SecurityContextHolder.getContext().authentication = jwtParser.getAuthentication(token)
        }

        filterChain.doFilter(request, response)
    }

    private fun resolvedToken(request: HttpServletRequest): String? =
        request.getHeader(JwtConstants.HEADER)?.also {
            if (it.startsWith(JwtConstants.PREFIX)) {
                return it.substring(JwtConstants.PREFIX.length)
            }
        }
}