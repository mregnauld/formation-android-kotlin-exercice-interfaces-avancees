package com.formationandroid.interfacesavancees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener
{

    companion object
    {
        // Constantes :
        const val EXTRA_PAGE = "EXTRA_PAGE"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        // init :
        super.onActivityCreated(savedInstanceState)

        // argument :
        val arguments = requireArguments()
        val page = arguments.getString(EXTRA_PAGE)

        // affichage :
        texte.text = page

        // listener :
        texte.setOnClickListener(this)
    }

    override fun onClick(view: View)
    {
        // lors du clic sur une page, on affiche les informations de cette page, en appelant une méthode de l'activité :
        if (activity is MainActivity)
        {
            (activity as MainActivity).afficherInfosPageCourante()
        }
    }

}