package com.example.student_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val position = intent.getIntExtra("student_position", -1)
        val student = Model.shared.students.getOrNull(position)

        if (student != null) {
            findViewById<TextView>(R.id.student_details_name_text_view).text = "Name: ${student.name}"
            findViewById<TextView>(R.id.student_details_id_text_view).text = "ID: ${student.id}"

            val editButton: Button = findViewById(R.id.student_details_edit_button)
            editButton.setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("student_position", position)
                startActivity(intent)
            }
        }
    }
}