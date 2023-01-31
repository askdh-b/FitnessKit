package rustam.urazov.fitnesskit.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import rustam.urazov.fitnesskit.R

class GeneralFragment : Fragment(R.layout.fragment_general) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bnvGeneral: BottomNavigationView = view.findViewById(R.id.bnvGeneral)
        val navController = (childFragmentManager.findFragmentById(R.id.fcvGeneral) as NavHostFragment).navController
        bnvGeneral.setupWithNavController(navController)
    }

}