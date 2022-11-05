package com.fastcampus.kotlinspring.todo.service

import com.fastcampus.kotlinspring.todo.api.model.TodoRequest
import com.fastcampus.kotlinspring.todo.domain.Todo
import com.fastcampus.kotlinspring.todo.domain.TodoRepository
import org.springframework.data.domain.Sort.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class TodoService(
    private val todoRepository: TodoRepository,
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Todo> =
        todoRepository.findAll(by(Direction.DESC, "id"))

    @Transactional
    fun findById(id: Long): Todo =
        todoRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    //기존에 Optional로 처리하는 것을 코틀린의 언어적인 차원에서 해결할수 있다,

    @Transactional
    fun create(request: TodoRequest?): Todo {
        checkNotNull(request) { "TodoRequest is null" }
        //null 안정성을 사용할 필요가 없다 -> checkNotNull을 통과한 이후부터는 컴파일러가 null이 아님을 알고 있기 때문
        val todo = Todo(
            title = request.title,
            description = request.description,
            done = request.done,
            createdAt = LocalDateTime.now(),
        )
        return todoRepository.save(todo)
    }

    @Transactional
    fun update(id: Long, request: TodoRequest?): Todo {
        checkNotNull(request) { "TodoRequest is null" }
        return findById(id).let {
            it.update(request.title, request.description, request.done)
            todoRepository.save(it)
        }
    }
    fun delete(id: Long) = todoRepository.deleteById(id)
}