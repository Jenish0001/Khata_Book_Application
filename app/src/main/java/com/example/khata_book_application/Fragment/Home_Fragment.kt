package com.example.khata_book_application.Fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context.MODE_PRIVATE
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
    lateinit var total_txt: TextView
    lateinit var txt1Income: TextView
    lateinit var txt3Expence: TextView
    lateinit var name_binss: TextView
    lateinit var cv_add_customer: RelativeLayout
    lateinit var rv_1: RelativeLayout
    lateinit var rg1: RadioGroup
    lateinit var stas1: String
    lateinit var savebtn: Button
    lateinit var j1: String

    var list = arrayListOf<ModelData>()
    var list1 = arrayListOf<ModelData>()

    var incomeTotal = 0
    var expTotal = 0
    var size: Int = 0


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home_, container, false)

        recycle_view_home = view.findViewById<RecyclerView>(R.id.recycle_view_home)
        ADD_CUSTOMER_BTN = view.findViewById<RelativeLayout>(R.id.ADD_CUSTOMER_BTN)
        cv_add_customer = view.findViewById<RelativeLayout>(R.id.cv_add_customer)
        rv_1 = view.findViewById<RelativeLayout>(R.id.rv_1)
        filterHome = view.findViewById<ImageView>(R.id.filterHome)
        total_txt = view.findViewById<TextView>(R.id.total_txt)
        txt1Income = view.findViewById<TextView>(R.id.txt1Income)
        txt3Expence = view.findViewById<TextView>(R.id.txt3Expence)
        name_binss = view.findViewById<TextView>(R.id.name_binss)

//        total_txt.text=list1.toString()

//        var intent = Intent
//            var t=intent.getStringExtra("t1")


//        fun isAutoTimeEnabled(activity: Activity) =
//            Settings.Global.getInt(activity.contentResolver, Settings.Global.AUTO_TIME) == 1
//
//        fun isAutoTimeZoneEnabled(activity: Activity) =
//            Settings.Global.getInt(activity.contentResolver, Settings.Global.AUTO_TIME_ZONE) == 1

        rv_1.setOnClickListener {

            var d1 = Dialog(mainActivity)

            d1.setContentView(R.layout.dialog_name_item)
            d1.show()

            var dialogEditTxtName = d1.findViewById<EditText>(R.id.dialogEditTxtName)
            var submitBtnDialog = d1.findViewById<Button>(R.id.submitBtnDialog)


            dialogEditTxtName.setOnClickListener {

                var j1 = dialogEditTxtName.text

            }
            submitBtnDialog.setOnClickListener {

                val j1 = dialogEditTxtName.text.toString()

                Toast.makeText(mainActivity, "$j1", Toast.LENGTH_SHORT).show()
                name_binss.text = j1


//                var i1 = Intent(activity, Rupees_Fragment::class.java)
//                i1.putExtra("name",j1)
//                startActivity(i1)


                createShr(j1)

                d1.dismiss()


            }

        }

        getShr()

        var db = DB_Helper(mainActivity)


        cv_add_customer.setOnClickListener {

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

                    stas1 = "0"


                } else {
                    stas1 = "1"

                }

                var db = DB_Helper(activity)
                list1 = db.readData1(stas1)

                Toast.makeText(mainActivity, "$stas1", Toast.LENGTH_LONG).show()

                setUpRv(list1)
                dialog.dismiss()

            }

        }

        return view

    }

    private fun createShr(j1: String) {
        var shr = requireActivity().getSharedPreferences("MyPref", MODE_PRIVATE)
        var edit = shr.edit();
        edit.putString("name", "$j1");
        edit.commit()
    }


    fun getShr(): String? {
        var shr = requireActivity().getSharedPreferences("MyPref", MODE_PRIVATE)
        var data = shr.getString("name", null)
        name_binss.text = data
        return data;

    }


    fun setUpRv(l1: ArrayList<ModelData>) {

        var adpter = New_Contect_Adpter(mainActivity, l1)
        var lm = LinearLayoutManager(mainActivity)
        recycle_view_home.layoutManager = lm
        recycle_view_home.adapter = adpter

    }

    @SuppressLint("ResourceAsColor")
    fun incomeExpenceCount(list: ArrayList<ModelData>) {
        var i = 0;
        while (i < list.size) {
            if (list[i].type.equals("0")) {
                incomeTotal = incomeTotal + list[i].ruppes.toInt()

            } else {
                expTotal = expTotal + list[i].ruppes.toInt()
            }
            i++
//            Toast.makeText(activity,"$incomeTotal",Toast.LENGTH_SHORT).show()

        }




        txt1Income.text = incomeTotal.toString()
        txt3Expence.text = expTotal.toString()

//        if (expTotal.toInt() == 0) {
//
//            binding11.txtExp.text = "0"
//
//        } else {
//            binding11.txtExp.text = (incomeTotal - expTotal).toString()
//        }
//        if (incomeTotal > expTotal) {
//            binding11.todayIncome.setImageResource(R.drawable.rupeeincome)
//            binding11.txtExp.setTextColor(Color.parseColor("#0F814D"))
//        } else if (incomeTotal < expTotal) {
//            binding11.todayIncome.setImageResource(R.drawable.rupeeexpence)
//            binding11.txtExp.setTextColor(Color.parseColor("#DF1837"))
//        }


    }


    override fun onResume() {

        incomeTotal = 0
        expTotal = 0

        super.onResume()
        var db = DB_Helper(mainActivity)
        this.list = db.readData()
        size = list.size

        try {
            incomeExpenceCount(list)
        } catch (e: Exception) {
        }

        setUpRv(list)

    }

}