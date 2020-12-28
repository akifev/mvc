package daniil.akifev.mvc.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity(name = "TaskList")
@Table(name = "list")
data class TaskList(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1,

    var name: String = "",

    @OneToMany(
        mappedBy = "taskList",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JsonManagedReference
    var tasks: MutableList<Task> = mutableListOf()
)
