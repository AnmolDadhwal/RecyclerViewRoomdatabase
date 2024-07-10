package com.view.recyclerviewroomdatabase

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.view.recyclerviewroomdatabase.databinding.ActivityMainBinding
import com.view.recyclerviewroomdatabase.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    var list= arrayListOf<TodoEntity>()
    var recyclerAdapter=RecyclerAdapter()
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding?.recyclerView?.layoutManager = linearLayoutManager
//        binding?.recyclerView?.adapter = recyclerAdapter

        binding?.fabAdd?.setOnClickListener {
            Dialog(this).apply {
                var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
                setContentView(binding?.root)
                dialogBinding.btnAdd.setOnClickListener {
                    if (dialogBinding.etTitle.text.toString().trim().isNullOrEmpty()){
                        dialogBinding.etTitle.error = "Enter Title"
                    }else if(dialogBinding.etDescription.text.toString().trim().isNullOrEmpty()){
                        dialogBinding.etDescription.error = "Enter Description"
                    }else if(dialogBinding.rbHigh.isChecked == false &&
                        dialogBinding.rbMedium.isChecked == false &&
                        dialogBinding.rbLow.isChecked == false){
                        Toast.makeText(this@MainActivity, "Select Priority", Toast.LENGTH_SHORT).show()
                    }else{

                    }
                }
            }
        }
    }
}