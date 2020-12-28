package daniil.akifev.mvc.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "Task")
@Table(name = "task")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1,

    var description: String = "",
    var done: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    var taskList: TaskList = TaskList()
)
