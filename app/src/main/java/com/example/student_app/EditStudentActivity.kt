package com.example.student_app


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val position = intent.getIntExtra("student_position", -1)
        val student = Model.shared.students.getOrNull(position)

        if (student != null) {
            val nameField: EditText = findViewById(R.id.edit_student_name_field)
            val idField: EditText = findViewById(R.id.edit_student_id_field)

            nameField.setText(student.name)
            idField.setText(student.id)

            findViewById<Button>(R.id.edit_student_save_button).setOnClickListener {
                student.name = nameField.text.toString()
                student.id = idField.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }

            findViewById<Button>(R.id.edit_student_delete_button).setOnClickListener {
                Model.shared.students.removeAt(position)

                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        }
    }
}