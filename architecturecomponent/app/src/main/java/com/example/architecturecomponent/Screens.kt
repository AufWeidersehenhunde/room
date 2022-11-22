package com.example.architecturecomponent

import com.example.architecturecomponent.addscreen.AddFragment
import com.example.architecturecomponent.editscreen.EditFragment
import com.example.architecturecomponent.homescreen.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun getEditTextFragment(uuid: String) = FragmentScreen { EditFragment.getInstance(uuid) }
    fun getHomeFragment() =  FragmentScreen { HomeFragment() }
    fun getAddFragment() =  FragmentScreen { AddFragment() }
}