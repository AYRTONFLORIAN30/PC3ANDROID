package com.florian.ayrton.laboratoriocalificado03.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.florian.ayrton.laboratoriocalificado03.model.Teacher
import com.florian.ayrton.laboratoriocalificado03.data.remote.RetrofitClient
import com.florian.ayrton.laboratoriocalificado03.databinding.ActivityEjercicio01Binding
import com.florian.ayrton.laboratoriocalificado03.ui.adapter.TeacherAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Ejercicio01Activity : AppCompatActivity(), TeacherAdapter.OnItemClickListener {

    private lateinit var binding: ActivityEjercicio01Binding
    private lateinit var teacherAdapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchTeachers()
    }

    private fun setupRecyclerView() {
        teacherAdapter = TeacherAdapter(emptyList(), this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio01Activity)
            adapter = teacherAdapter
        }
    }

    private fun fetchTeachers() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitClient.apiService.getTeachers()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    teacherAdapter.teachers = response.body()?.teachers ?: emptyList()
                    teacherAdapter.notifyDataSetChanged()
                } else {
                    // Handle error, response.errorBody() or show an error message
                }
            }
        }
    }

    override fun onItemClick(teacher: Teacher) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${teacher.phone}")
        }
        startActivity(intent)
    }

    override fun onItemLongClick(teacher: Teacher) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:${teacher.email}")
        }
        startActivity(intent)
    }
}
