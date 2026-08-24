package com.projetos.filmei.domain.usecase

/**
 * Contrato padrão para casos de uso.
 *
 * Params: entrada do caso de uso (use [Unit] quando não houver parâmetros).
 * Result: tipo de retorno — normalmente [Result].
 *
 * Exemplo:
 * ```
 * class GetNotesUseCase(
 *     private val repository: NoteRepository
 * ) : UseCase<Unit, Result<List<Note>, DataError>> {
 *     override suspend fun invoke(params: Unit) = repository.getNotes()
 * }
 * ```
 */
interface UseCase<in Params, out Result> {
    suspend operator fun invoke(params: Params): Result
}

/** Sugar para casos de uso que não recebem parâmetros. */
interface NoParamsUseCase<out Result> : UseCase<Unit, Result> {
    suspend operator fun invoke(): Result = invoke(Unit)
}
