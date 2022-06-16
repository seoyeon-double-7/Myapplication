package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_study2)

//        식별자를 이용한 뷰 접근
//        Button 타입을 줌
//        var myButton : Button = findViewById(R.id.my_button)
//        Button 타입을 생략하고, 타입추론 시킴
//        var myEditText = findViewById(R.id.my_edittext) as EditText
//        var myTextView = findViewById<TextView>(R.id.my_textview)

//        myButton.setOnClickListener(
////            클래스 안에 인터페이스 정의할 때 클래스이름. ~ 형식으로 코드 작성해야한다.
//            object : View.OnClickListener{
//                override fun onClick(p0: View?) {
//                    Toast.makeText(this@MainActivity,
//                    "클릭하셨습니다링", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//        )

//      myButton.setOnClickListener {
//          함수형 인터페이스만 줄이기 가능
//          v ->
//          Toast.makeText(this, "클릭했습니당당구리!", Toast.LENGTH_SHORT).show()
//          Log.d("my_tag", "Hello")
//      }
        val checkBox = findViewById<CheckBox>(R.id.checkbox1)
        checkBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                // 체크박스가 체크되었을 때 로직
                Log.d("my_tag", "checked")
            } else {
                // 아닌 경우 로직
                Log.d("my_tag", "unchecked")
            }
        }

        val group = findViewById<RadioGroup>(R.id.radio_group)
        group.setOnCheckedChangeListener { radioGroup, id ->
            Log.d("my_tag", id.toString())
            //when - case
            when (id) {
                R.id.radio_button1 -> {
                    Log.d("my_tag", "버튼 1 선택")
                }
                R.id.radio_button2 -> {
                    Log.d("my_tag", "버튼 2 선택")
                }
            }

        }
        val spinner = findViewById<Spinner>(R.id.my_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this, // context: 쓰는 거 아님~!
            R.array.my_str_array,
            android.R.layout.simple_spinner_item
        )   //레이아웃 정보
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adapter

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?,
                                            p1: View?,
                                            p2: Int,
                                            p3: Long) {
                    val selected =
                        p0?.getItemAtPosition(p2).toString()

                    Log.d("my_tag", selected)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        application
    }
}