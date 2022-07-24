package com.example.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ussd.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_balance ->{
                    val number = "*100#"
                    val intent =  Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null))
                    startActivity(intent)
                    true
                }
                R.id.nav_operator ->{
                    val number = "1099"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts ("tel", number, null))
                    startActivity(intent)
                    true
                }
                else -> {
                    false
                }
            }
        }

        floatingActionButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, HomeFragment()).commit()
        }

    }
}