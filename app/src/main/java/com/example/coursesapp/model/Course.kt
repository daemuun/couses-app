package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val courseNameId: Int,
    val countCourses: Int,
    @DrawableRes val courseImageId: Int
)
