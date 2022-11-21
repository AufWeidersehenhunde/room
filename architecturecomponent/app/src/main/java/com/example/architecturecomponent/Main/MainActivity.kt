package com.example.architecturecomponent.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.architecturecomponent.R
import com.example.architecturecomponent.homescreen.HomeViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModelMain: MainViewModel by viewModel()
    private val navigatorHolder by inject<NavigatorHolder>()

    private val navigator = object : AppNavigator(this, R.id.container) {
        override fun setupFragmentTransaction(
            screen: FragmentScreen,
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment
        ) {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelMain.create()
        setContentView(R.layout.activity_main)

    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}