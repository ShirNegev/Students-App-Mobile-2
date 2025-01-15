package com.example.student_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = StudentsRecyclerAdapter(Model.shared.students) { student, position ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student_position", position)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        val addStudentButton: Button = findViewById(R.id.main_activity_add_student_button)
        addStudentButton.setOnClickListener {
            startActivity(Intent(this, AddStudentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<RecyclerView>(R.id.students_recycler_view).adapter?.notifyDataSetChanged()
    }
}