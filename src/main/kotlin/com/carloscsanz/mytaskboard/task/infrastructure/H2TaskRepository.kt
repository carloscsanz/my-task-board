package com.carloscsanz.mytaskboard.task.infrastructure

import com.carloscsanz.mytaskboard.task.domain.Task
import com.carloscsanz.mytaskboard.task.domain.TaskRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.UUID

@Repository
class H2TaskRepository(
    private val db: JdbcTemplate,
) : TaskRepository {
    override fun findAll(): Set<Task> {
        return db
            .query("SELECT * FROM tasks", TaskMapper::mapRow)
            .toSet()
    }

    override fun create(task: Task) {
        db
            .update(
                "INSERT INTO tasks VALUES (?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                task.name.value,
                task.description.value,
                task.status.name,
            )
    }
}

object TaskMapper : RowMapper<Task> {
    override fun mapRow(
        rs: ResultSet,
        rowNum: Int,
    ): Task =
        Task(
            name = rs.getString("name"),
            description = rs.getString("description"),
            status = rs.getString("status"),
        )
}
