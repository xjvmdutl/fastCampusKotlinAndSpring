package com.fastcampus.kotlinspring.todo.api.model

import com.fastcampus.kotlinspring.todo.domain.Todo
import com.fasterxml.jackson.annotation.JsonIgnore

data class TodoListResponse(
    val items: List<TodoResponse>,
) {
    val size: Int
        @JsonIgnore //Jackson Json에서 size를 프로퍼티로 내려주기 떄문에 해당 애노테이션을 추가해주어야 한다.
        get() = items.size //유틸리티성 프로퍼티를 만들어 함수를 만들지 않고 size를 반환한다.

    fun get(index: Int) = items[index]

    companion object {
        fun of(todoList: List<Todo>) =
            //TodoListResponse(todoList.map { TodoResponse.of(it) })
            TodoListResponse(todoList.map(TodoResponse::of))
    }
}