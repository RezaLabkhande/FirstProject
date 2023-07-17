package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import retrofit2.Call

import retrofit2.Response


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button2).setOnClickListener {
            Send_Rrequest()
        }



    }

    fun Send_Rrequest() {
//

        var data=active()
        data.activationCode="vsvsvas"
        data.cpuID="svsv"

        var BaseClass = BaseServer()
        try {
//            http://91.108.148.38:9595/tozie
            var baseserver = BaseClass.getApi("http://91.108.148.38:9595/atirantozie/")?.activation(data)
            baseserver?.enqueue(object : retrofit2.Callback<model_activation> {
                override fun onResponse(
                    call: Call<model_activation>,
                    response: Response<model_activation>
                ) {



                }




                override fun onFailure(call: Call<model_activation>, t: Throwable) {
                    Log.i("sdvhnsadvguidsan", t.message.toString())
                    Toast.makeText(
                        this@MainActivity,
                        "مشکلی در ارتباط با سرور به وجود آمده است",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
            baseserver?.request()
        } catch (E: Exception) {
            Log.i("sfvksdfkgbsdfmg", E.message.toString())
            Toast.makeText(this, "آدرس سرور اشتباه وارد شده است ", Toast.LENGTH_SHORT).show()
        }


    }
}