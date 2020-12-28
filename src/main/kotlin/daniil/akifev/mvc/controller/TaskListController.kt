package daniil.akifev.mvc.controller

import daniil.akifev.mvc.entity.Task
import daniil.akifev.mvc.entity.TaskList
import daniil.akifev.mvc.repository.TaskListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class TaskListController {
    @Autowired
    lateinit var taskListRepository: TaskListRepository

    @GetMapping("/lists")
    fun lists(modelMap: ModelMap): String {
        modelMap.addAttribute("lists", taskListRepository.findAll().toList())
        return "lists"
    }

    @GetMapping("/lists/{id}")
    fun list(
        modelMap: ModelMap,
        @PathVariable("id") id: Long
    ): String {
        val list = taskListRepository.getTaskListById(id)
        modelMap.addAttribute("list", list)
        return "list"
    }

    @PostMapping("/addList")
    fun addNewList(@RequestParam("name") name: String): String {
        val taskList = TaskList(name = name)
        taskListRepository.save(taskList)

        return "redirect:/lists"
    }

    @PostMapping("/deleteList")
    fun deleteList(@RequestParam("id") id: Long): String {
        taskListRepository.removeTaskListById(id)

        return "redirect:/lists"
    }

    @PostMapping("/addTask")
    @Modifying
    @Transactional
    fun addNewTask(
        @RequestParam("listId") listId: Long,
        @RequestParam("description") description: String,
    ): String {
        val taskList = taskListRepository.getTaskListById(listId)
        val task = Task(description = description, taskList = taskList)
        taskList.tasks.add(task)

        return "redirect:/lists/$listId"
    }
}