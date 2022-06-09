package com.example.khata_book_application.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.Controller.New_Contect_Adpter
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.R

class Add_Custmer_Data : AppCompatActivity() {

    lateinit var edit_name_data: EditText
    lateinit var edit_mobile_data: EditText
    lateinit var update_item_btn: Button
    lateinit var name_add_customer: TextView
    lateinit var income_btn: Button
    lateinit var expence_btn: Button
    lateinit var recycle_View: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_custmer_data)

        blinding()

        var name1 = intent.getStringExtra("name")

        if (intent.hasExtra("name")) {

            val title = intent.getStringExtra("name")
            name_add_customer.text = name1

//            Toast.makeText(this, "$title", Toast.LENGTH_SHORT).show()

        }

        income_btn.setOnClickListener {
            val intent = Intent(this, Money_Show_Activity::class.java)

            intent.putExtra("type", "1")
            intent.putExtra("name",name1)

            startActivity(intent)

        }

        expence_btn.setOnClickListener {

            val intent = Intent(this, Money_Show_Activity::class.java)

            intent.putExtra("type", "0")
            intent.putExtra("name",name1)

            startActivity(intent)


        }

    }
    fun blinding() {

        name_add_customer = findViewById<TextView>(R.id.name_add_customer)
        income_btn = findViewById<Button>(R.id.income_btn)
        expence_btn = findViewById<Button>(R.id.expence_btn)
//        recycle_View = findViewById<RecyclerView>(R.id.recycle_View)

    }

//    fun setUpRv(l1: ArrayList<ModelData>) {
//        var adpter = New_Contect_Adpter(this, l1)
//        var lm = LinearLayoutManager(this)
//        recycle_View.layoutManager = lm
//        recycle_View.adapter = adpter
//
//    }

}


