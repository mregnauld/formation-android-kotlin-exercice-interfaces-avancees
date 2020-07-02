package com.formationandroid.interfacesavancees

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MainDialogFragment : DialogFragment()
{

    companion object
    {
        // Constantes :
        const val TAG_MAIN_DIALOG = "TAG_MAIN_DIALOG"
        const val EXTRA_NOMBRE_MOTS = "EXTRA_NOMBRE_MOTS"
        const val EXTRA_NUMERO_PAGE = "EXTRA_NUMERO_PAGE"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        // arguments :
        val arguments = requireArguments()

        // récupération des arguments :
        val nombreMots = arguments.getInt(EXTRA_NOMBRE_MOTS)
        val numeroPage = arguments.getInt(EXTRA_NUMERO_PAGE)

        // initialisation de la boîte de dialogue :
        val builder = AlertDialog.Builder(requireContext())
        builder
            .setMessage(getString(R.string.main_dialogue_message, nombreMots, numeroPage))
            .setPositiveButton(R.string.main_dialogue_ok) { _, _ -> }

        // création de la boîte de dialogue:
        return builder.create()
    }
}
