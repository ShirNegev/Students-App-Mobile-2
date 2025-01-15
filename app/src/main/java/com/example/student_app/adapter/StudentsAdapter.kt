package com.example.student_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsRecyclerAdapter(
    private val students: MutableList<Student>,
    private val onStudentClick: (Student, Int) -> Unit
) : RecyclerView.Adapter<StudentsRecyclerAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.student_row_name_text_view)
        val idTextView: TextView = itemView.findViewById(R.id.student_row_id_text_view)
        val studentCheckBox: CheckBox = itemView.findViewById(R.id.student_row_check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.nameTextView.text = student.name
        holder.idTextView.text = student.id
        holder.studentCheckBox.isChecked = student.isChecked

        // Toggle the check state when checkbox is clicked
        holder.studentCheckBox.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
        }

        // Open details screen when row is clicked
        holder.itemView.setOnClickListener {
            onStudentClick(student, position)
        }
    }

    override fun getItemCount(): Int = students.size
}