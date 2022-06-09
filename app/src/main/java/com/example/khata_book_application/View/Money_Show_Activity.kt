package com.example.khata_book_application.View

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khata_book_application.Controller.New_Contect_Adpter
import com.example.khata_book_application.DB_Helper
import com.example.khata_book_application.Fragment.Home_Fragment
import com.example.khata_book_application.Fragment.ModelData
import com.example.khata_book_application.R

class Money_Show_Activity : AppCompatActivity() {


    lateinit var Title_text_money_activity: TextView
    lateinit var left_arrow_money_activity: ImageView
    lateinit var save_money_activity: Button
    lateinit var edt_amount_money: EditText


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_show)
        blinding()

        var name1 = intent.getStringExtra("name")
        var title = intent.getStringExtra("type")


        if (title.equals("1")) {

//            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()


            Title_text_money_activity.text = name1.toString()
            Title_text_money_activity.setTextColor(getColor(R.color.green))
            save_money_activity.setBackgroundColor(getColor(R.color.green))


//            Toast.makeText(this, "$income1", Toast.LENGTH_SHORT).show()



        } else {


            Title_text_money_activity.text = name1.toString()
            Title_text_money_activity.setTextColor(this.getColor(R.color.red))
            save_money_activity.setBackgroundColor(getColor(R.color.red))

        }



//        var db = DB_Helper(this)

        save_money_activity.setOnClickListener {
////
//            if(title.equals("1"))
//            {
//
//
////                val income1 = edt_amount_money.text
////                val expence = edt_amount_money.text
//
//
////                db.insertData1(income1.toString(), expence.toString())
//
////                var intent = Intent(this, Home_Fragment::class.java)
//
////                intent.putExtra("t1",income1)
//
//                startActivity(intent)
////                Toast.makeText(this,"$income1",Toast.LENGTH_SHORT).show()
//            }
//            else
//            {
////                val expence = edt_amount_money.text
//
////                Toast.makeText(this,"$expence",Toast.LENGTH_SHORT).show()
//            }
//

//            Toast.makeText(this, "$income1", Toast.LENGTH_SHORT).show()
        //        db.insertData(edt_amount_money.text.toString())

        }


    }

    fun blinding() {

        Title_text_money_activity = findViewById<TextView>(R.id.Title_text_money_activity)
        left_arrow_money_activity = findViewById<ImageView>(R.id.left_arrow_money_activity)
        save_money_activity = findViewById<Button>(R.id.save_money_activity)
        edt_amount_money = findViewById<EditText>(R.id.edt_amount_money)

    }


}