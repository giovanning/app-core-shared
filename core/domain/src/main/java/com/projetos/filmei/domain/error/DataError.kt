package com.projetos.filmei.domain.error

sealed interface DataError : Error {
    enum class Local : DataError {
        DISK_FULL, NOT_FOUND, UNKNOWN
    }
    enum class Network : DataError {
        REQUEST_TIMEOUT, TOO_MANY_REQUESTS, NO_INTERNET,
        SERVER_ERROR, SERIALIZATION, UNAUTHORIZED, UNKNOWN
    }
}