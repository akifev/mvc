package daniil.akifev.mvc.controller

import daniil.akifev.mvc.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class TaskController {
    @Autowired
    lateinit var taskRepository: TaskRepository

    @PostMapping("/deleteTask")
    fun deleteTask(
        @RequestParam("id") id: Long,
        @RequestParam("listId") listId: Long
    ): String {
        taskRepository.removeTaskById(id)

        return "redirect:/lists/$listId"
    }

    @PostMapping("/completeTask")
    fun completeTask(
        @RequestParam("id") id: Long,
        @RequestParam("listId") listId: Long
    ): String {
        taskRepository.completeTaskById(id)

        return "redirect:/lists/$listId"
    }
}