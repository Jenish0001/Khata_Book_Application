package com.example.khata_book_application.Fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.khata_book_application.Controller.New_Contect_Adpter
import com.example.khata_book_application.DB_Helper
import com.example.khata_book_application.R
import com.example.khata_book_application.View.MainActivity
import com.example.khata_book_application.View.New_Contect_Activity

class Home_Fragment(val mainActivity: MainActivity) : Fragment() {

    lateinit var recycle_view_home: RecyclerView
    lateinit var ADD_CUSTOMER_BTN: RelativeLayout
    lateinit var filterHome: ImageView
    lateinit var cv_add_customer: RelativeLayout
    lateinit var rg1: RadioGroup
    lateinit var stas1: String
    lateinit var savebtn: Button


    var list = arrayListOf<ModelData>()
    var list1 = arrayListOf<ModelData>()

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home_, container, false)

        recycle_view_home = view.findViewById<RecyclerView>(R.id.recycle_view_home)
        ADD_CUSTOMER_BTN = view.findViewById<RelativeLayout>(R.id.ADD_CUSTOMER_BTN)
        cv_add_customer = view.findViewById<RelativeLayout>(R.id.cv_add_customer)
        filterHome = view.findViewById<ImageView>(R.id.filterHome)


//        var intent = Intent
//            var t=intent.getStringExtra("t1")


        var db = DB_Helper(mainActivity)
//        list = db.readData()
//        setUpRv(list)


        cv_add_customer.setOnClickListener {

//            Toast.makeText(activity, "  WELCOME  ", Toast.LENGTH_SHORT).show()

            val intent = Intent(activity, New_Contect_Activity::class.java)

            startActivity(intent)


        }

//        if (intent.hasExtra("name")) {
//            val title = intent.getStringExtra("name")
//            name_add_customer.text = title
//
//            Toast.makeText(this,"$title",Toast.LENGTH_SHORT).show()
//
//        }

        filterHome.setOnClickListener {

            var dialog = Dialog(mainActivity)
            dialog.setContentView(R.layout.filter_item)

            rg1 = dialog.findViewById<RadioGroup>(R.id.rg1)
            savebtn = dialog.findViewById<Button>(R.id.savebtn)

            dialog.show()
            savebtn.setOnClickListener {

                if (rg1.getCheckedRadioButtonId() == R.id.rb1) {
                    stas1 = "Income"

                } else {

                    stas1 = "Expense"

                }

                Toast.makeText(mainActivity, "$stas1", Toast.LENGTH_LONG).show()

                dialog.dismiss()
                filterItem(stas1)

            }


        }

        return view

    }

    fun setUpRv(l1: ArrayList<ModelData>) {

        var adpter = New_Contect_Adpter(mainActivity, l1)
        var lm = LinearLayoutManager(mainActivity)
        recycle_view_home.layoutManager = lm
        recycle_view_home.adapter = adpter

    }

    override fun onResume() {
        super.onResume()
        var db = DB_Helper(mainActivity)
        list = db.readData()
        setUpRv(list)

    }

    fun filterItem(stas1: String) {
        var i = 0
        do {

            if (list[i].type.equals(stas1)) {

                list1.add(list[i])


            } else {
                list1.add(list[i])



            }

            i++
        } while (i < list.size)
        setUpRv(list1)
    }
}

