package com.cmd.schedulr.domain.entity.mapped

import androidx.room.Embedded
import androidx.room.Relation
import com.cmd.schedulr.domain.entity.TaskTag
import com.cmd.schedulr.domain.entity.UserColor

data class TaskTagMapped (
    @Embedded
    val taskTag: TaskTag,
    @Relation(
        parentColumn = "color_id",
        entityColumn = "id"
    )
    val color: UserColor?
)