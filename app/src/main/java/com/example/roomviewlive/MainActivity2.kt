package com.example.roomviewlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.roomandrecycleview.db.UserEntity
import com.example.roomandrecycleview.db2.UserEntity2
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity(), RecyclerViewAdapter2.RowClickListener {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter2
    lateinit var viewModel: MainActivityViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        recyclerView2.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)
            recyclerViewAdapter = RecyclerViewAdapter2(this@MainActivity2)
            adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }

        viewModel = ViewModelProvider(this).get(MainActivityViewModel2::class.java)
        viewModel.getAllUsersObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }


        saveButton2.setOnClickListener {
            val name = nameInput2.text.toString()
            val email = emailInput2.text.toString()
            val phone = phoneInput2.text.toString()
            if (saveButton2.text.equals("Save")) {
                val user = UserEntity2(0, name, email, phone)
                viewModel.insertUserInfo(user)
            } else {
                val user = UserEntity2(
                    nameInput2.getTag(nameInput2.id).toString().toInt(),
                    name,
                    email,
                    phone
                )
                viewModel.updateUserInfo(user)
                saveButton2.setText("Save")
            }
            nameInput2.setText("")
            emailInput2.setText("")
            phoneInput2.setText("")
        }
    }
    override fun onDeleteUserClickListener(user: UserEntity2) {
        viewModel.deleteUserInfo(user)
    }


    override fun onItemClickListener(user: UserEntity2) {
        nameInput2.setText(user.name)
        emailInput2.setText(user.email)
        phoneInput2.setText(user.phone)
        nameInput2.setTag(nameInput2.id, user.id)
        saveButton2.setText("Update")
    }
}