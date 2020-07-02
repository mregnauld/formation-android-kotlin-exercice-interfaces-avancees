package com.formationandroid.interfacesavancees

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

	// Adapter :
	private lateinit var mainStateAdapter: MainStateAdapter


	override fun onCreate(savedInstanceState: Bundle?)
	{
		// init :
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// exemple de textes en dur :
		val listePages = ArrayList<String>()
		listePages.add(getString(R.string.main_texte_1))
		listePages.add(getString(R.string.main_texte_2))
		listePages.add(getString(R.string.main_texte_3))
		listePages.add(getString(R.string.main_texte_4))
		listePages.add(getString(R.string.main_texte_5))
		listePages.add(getString(R.string.main_texte_6))
		listePages.add(getString(R.string.main_texte_7))
		listePages.add(getString(R.string.main_texte_8))
		listePages.add(getString(R.string.main_texte_9))

		// viewpager et adapter :
		mainStateAdapter = MainStateAdapter(this, listePages)
		viewpager.adapter = mainStateAdapter
	}

	/**
	 * Affichage des informations de la page courante.
	 */
	fun afficherInfosPageCourante()
	{
		// récupération du texte de la page courante :
		val textePage = mainStateAdapter.getTextePage(viewpager.currentItem)

		// décompte des mots :
		val nombreMots = textePage.split("\\s+".toRegex()).size

		// création de la boîte de dialogue :
		val mainDialogFragment = MainDialogFragment()

		// arguments pour la boîte de dialogue :
		val bundle = Bundle()
		bundle.putInt(MainDialogFragment.EXTRA_NOMBRE_MOTS, nombreMots)
		bundle.putInt(MainDialogFragment.EXTRA_NUMERO_PAGE, viewpager.currentItem + 1)
		mainDialogFragment.arguments = bundle

		// affichage de la boîte de dialogue :
		mainDialogFragment.show(supportFragmentManager, MainDialogFragment.TAG_MAIN_DIALOG)
	}

}