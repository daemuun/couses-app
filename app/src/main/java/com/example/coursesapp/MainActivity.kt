package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.Datasourse
import com.example.coursesapp.model.Course
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoursesGridLayout(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(course.courseImageId),
                contentDescription = null,
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
                Text(
                    text = stringResource(course.courseNameId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    Image(
                        painter = painterResource(R.drawable.count_image),
                        contentDescription = null,
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = course.countCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CoursesGridLayout(modifier: Modifier = Modifier) {
    val courses = Datasourse.getAllCourses()
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), modifier = modifier) {
        items(courses) { course ->
            CourseCard(course, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun CourceCardPreview() {
    CoursesAppTheme {
        CourseCard(Course(R.string.film, 123, R.drawable.film))
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesGridLayoutPreview() {
    CoursesAppTheme {
        CoursesGridLayout()
    }
}