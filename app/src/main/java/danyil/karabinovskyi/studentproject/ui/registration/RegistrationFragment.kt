package danyil.karabinovskyi.studentproject.ui.registration

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.shape.CornerFamily
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.BaseStateFragment
import danyil.karabinovskyi.studentproject.databinding.FragmentRegistrationBinding
import danyil.karabinovskyi.studentproject.ui.primary.PrimaryViewModel
import danyil.karabinovskyi.studentproject.utils.setOnClickWithDebounce


@AndroidEntryPoint
class RegistrationFragment : BaseStateFragment<FragmentRegistrationBinding>() {

    override val layoutId = R.layout.fragment_registration

    val viewModel: PrimaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        initListeners()
    }

    private fun setupUI(){

        val items = listOf("Material", "Design", "Components", "Android", "Material", "Design",
                "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android",
                "Material", "Design", "Components", "Android", "Material", "Design", "Components",
                "Android", "Material", "Design", "Components", "Android", "Material", "Design",
                "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android", "Material",
                "Design", "Components", "Android", "Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(requireContext(), R.layout.university_list_item, items)
        (binding.universitiesDropDown.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        hideKeyboard(requireActivity())
        binding.cardView.foreground = ContextCompat.getDrawable(requireActivity(), R.drawable.shape_right_panel);
        val radius = resources.getDimension(R.dimen.corners)

        // Using this corner builder, because style and drawable doesent work in this case TODO:fix
        binding.cardView.shapeAppearanceModel = binding.cardView.shapeAppearanceModel
                .toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomRightCornerSize(0f)
                .setTopRightCornerSize(0f)
                .build()
    }
    private fun initListeners(){
        binding.signUpButton.setOnClickWithDebounce {
            findNavController().navigate(RegistrationFragmentDirections.registrationToGlobalActivity())
            requireActivity().finish()
        }
        binding.login.setOnClickWithDebounce {
            findNavController().navigate(RegistrationFragmentDirections.registrationToLogin())
        }
    }
}