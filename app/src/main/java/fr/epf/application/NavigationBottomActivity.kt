package fr.epf.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationBottomActivity : AppCompatActivity() {

    val rappelsFragment = RappelsFragment()
    val depensesFragment = DepensesFragment()
    val listeFragment = ListeFragment()
    val parametresFragment = ParametresFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bottom)
        makeCurrentFragment(rappelsFragment)


        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.onglet_rappels->makeCurrentFragment(rappelsFragment)
                R.id.onglet_depenses->makeCurrentFragment(depensesFragment)
                R.id.onglet_liste->makeCurrentFragment(listeFragment)
                R.id.onglet_reglages->makeCurrentFragment(parametresFragment)

            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}