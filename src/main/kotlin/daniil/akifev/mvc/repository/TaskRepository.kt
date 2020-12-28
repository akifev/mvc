package daniil.akifev.mvc.repository

import daniil.akifev.mvc.entity.Task
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface TaskRepository : CrudRepository<Task, Long> {
    @Modifying
    @Transactional
    @Query(value = "update task set done = true where id = ?1", nativeQuery = true)
    fun completeTaskById(id: Long)

    @Transactional
    fun removeTaskById(id: Long)
}