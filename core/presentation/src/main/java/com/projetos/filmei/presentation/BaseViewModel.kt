package com.projetos.filmei.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Base MVI ViewModel compartilhada pelos apps.
 *
 * Propositalmente SEM nenhuma anotação de DI (@HiltViewModel, @KoinViewModel etc).
 * Funciona igual para Koin, Hilt, ou qualquer outro framework — a anotação de DI
 * vai na classe concreta (leaf), não aqui.
 *
 * @param State   dados imutáveis renderizados na tela
 * @param Action  intents disparados pela UI
 * @param Event   efeitos de disparo único (navegação, snackbar, etc.)
 */
abstract class BaseViewModel<State : Any, Action : Any, Event : Any>(
    initialState: State
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    public val state: StateFlow<State> = _state.asStateFlow()

    private val _events = Channel<Event>()
    public val events = _events.receiveAsFlow()

    /** Ponto de entrada único para a UI disparar intents. */
    public abstract fun onAction(action: Action)

    /** Atualiza o state de forma segura via `.update { }`. */
    protected fun updateState(reducer: (State) -> State) {
        _state.update(reducer)
    }

    /** Emite um evento de disparo único (navegação, snackbar, etc.). */
    protected fun sendEvent(event: Event) {
        viewModelScope.launch {
            _events.send(event)
        }
    }
}

private fun <T> MutableStateFlow<T>.update(reducer: (T) -> T) {
    this.value = reducer(this.value)
}
