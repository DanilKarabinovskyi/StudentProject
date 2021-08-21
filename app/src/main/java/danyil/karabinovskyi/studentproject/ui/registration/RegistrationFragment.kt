package danyil.karabinovskyi.studentproject.ui.registration

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import danyil.karabinovskyi.studentproject.R

class RegistrationFragment: Fragment(R.layout.registration_fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = view?.findViewById<Button>(R.id.button)
//        findNavController().navigate(R.id.action_registrationFragment_to_nav_graph_primary)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToGlobalActivity())
            requireActivity().finish()
        }, 2000)
    }
}