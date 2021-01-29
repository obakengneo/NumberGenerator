package com.obakengneo.numbergenerator.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_menu.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utility().setTheme(this, this)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setUpBottomNavBar(navController)
    }

    private fun setUpBottomNavBar(navController: NavController) {
        bottom_nav.let { NavigationUI.setupWithNavController(it, navController) }
    }

    private fun showBottomNavigationBar() {
        val view: View = layoutInflater.inflate(R.layout.main_menu, null)
        val bottomSheetDialog = BottomSheetDialog(this)

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.settings.setOnClickListener {
            val intent = Intent(this, ActivitySettings::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        view.rateApp.setOnClickListener {
            intentHandler("Rate")
            bottomSheetDialog.dismiss()
        }

        view.shareApp.setOnClickListener {
            intentHandler("Share")
            bottomSheetDialog.dismiss()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        showBottomNavigationBar()
        return true
    }

    private fun intentHandler(navigateTo: String) {
        when (navigateTo) {
            "Rate" -> {
                val browse = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=com.obakengneo.numbergenerator")
                )
                startActivity(browse)

                Utility().displayToast(
                    this,
                    "I would highly appreciate a 5 star rating. Thank you in advance."
                )
            }
            "Share" -> {
                val intentShare = Intent()
                intentShare.action = Intent.ACTION_SEND
                intentShare.putExtra(
                    Intent.EXTRA_TEXT,
                    "Get Randomize App\r\n http://play.google.com/store/apps/details?id=com.obakengneo.numbergenerator"
                )
                intentShare.type = "text/plain"

                startActivity(Intent.createChooser(intentShare, "Share link via:"))
            }
        }
    }
}
