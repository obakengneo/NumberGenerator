package com.example.numbergenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_menu.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        setFragment(RandomFragment())

        val actionBar = supportActionBar

        actionBar!!.title = "Random Generator"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_open_24)
    }

    override fun onSupportNavigateUp(): Boolean {
        bottomMenuPopUp()
        return true
    }

    private fun bottomMenuPopUp () {
        val view = layoutInflater.inflate(R.layout.bottom_menu, null)
        val bottomSheetDialog = BottomSheetDialog(this)

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.thaboSheet.setOnClickListener {
            setFragment(TeamsFragment())
            bottomSheetDialog.dismiss()
        }

        view.mahlokoSheet.setOnClickListener {
            setFragment(RandomFragment())
            bottomSheetDialog.dismiss()
        }

        view.leseliSheet.setOnClickListener {
            setFragment(CoinFragment())
            bottomSheetDialog.dismiss()
        }

        view.letlotloSheet.setOnClickListener {
            setFragment(DiceFragment())
            bottomSheetDialog.dismiss()
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}
