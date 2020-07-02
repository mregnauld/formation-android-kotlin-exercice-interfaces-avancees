package com.formationandroid.interfacesavancees

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainStateAdapter(mainActivity: MainActivity, val listePages: List<String>) : FragmentStateAdapter(mainActivity)
{

    override fun createFragment(position: Int): Fragment
    {
        // on instancie un fragment pour la page demandée :
        val mainFragment = MainFragment()

        // on lui passe en paramètre le texte à la position demandée :
        val bundle = Bundle()
        bundle.putString(MainFragment.EXTRA_PAGE, listePages[position])
        mainFragment.arguments = bundle

        // on retourne le fragment :
        return mainFragment
    }

    override fun getItemCount(): Int = listePages.size

    /**
     * Retourne le texte de la page demandée.
     * @param position Numéro de page
     */
    fun getTextePage(position: Int): String = listePages[position]

}