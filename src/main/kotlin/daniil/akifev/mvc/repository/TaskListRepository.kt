package daniil.akifev.mvc.repository

import daniil.akifev.mvc.entity.TaskList
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TaskListRepository : CrudRepository<TaskList, Long> {
    fun getTaskListById(id: Long): TaskList

    @Transactional
    fun removeTaskListById(id: Long)
}