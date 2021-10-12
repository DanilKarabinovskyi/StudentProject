package danyil.karabinovskyi.studentproject.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.shape.CornerFamily
import dagger.hilt.android.AndroidEntryPoint
import danyil.karabinovskyi.studentproject.R
import danyil.karabinovskyi.studentproject.base.WrappedResponse
import danyil.karabinovskyi.studentproject.data.registration.remote.dto.RegistrationResponse
import danyil.karabinovskyi.studentproject.databinding.FragmentRegistrationBinding
import danyil.karabinovskyi.studentproject.domain.registration.entity.RegistrationEntity
import danyil.karabinovskyi.studentproject.domain.registration.requests.RegistrationRequest
import danyil.karabinovskyi.studentproject.utils.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    val layoutId = R.layout.fragment_registration

    @Inject
    lateinit var sharedPrefs: SharedPrefs
    val viewModel: RegistrationViewModel by viewModels()

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupUI()
        initListeners()
        initObservers()
    }
    private fun initObservers(){
        viewModel.mState
                .flowWithLifecycle(lifecycle,  Lifecycle.State.STARTED)
                .onEach { state -> handleStateChange(state) }
                .launchIn(lifecycleScope)
    }

    private fun handleStateChange(state: RegistrationState){
        when(state){
            is RegistrationState.Init -> Unit
            is RegistrationState.Error -> handleError(state.rawResponse)
            is RegistrationState.Success -> handleSuccess(state.registrationEntity)
            is RegistrationState.ShowToast -> requireContext().toast(state.message)
            is RegistrationState.IsLoading -> handleLoading(state.isLoading)
        }
    }

    private fun handleError(response: WrappedResponse<RegistrationEntity>){
    }

    private fun handleLoading(isLoading: Boolean){
        when(isLoading){
            true -> {
                binding.loader.visible()
            }
            false -> {
                binding.loader.gone()
            }
        }
    }

    private fun handleSuccess(registrationEntity: RegistrationEntity){
        sharedPrefs.saveToken(registrationEntity.token)
        findNavController().navigate(RegistrationFragmentDirections.registrationToGlobalActivity())
        requireActivity().finish()
    }
    private fun setupUI(){

        val items = listOf("Material", "Design", "Components", "Android", "Material", "Design")
        val adapter = ArrayAdapter(requireContext(), R.layout.university_list_item, items)
        (binding.universitiesDropDown.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        requireView().hideKeyboard()
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
            if(validate())
                viewModel.registrate(RegistrationRequest(
                        firstName = binding.name.editText?.text.toString(),
                        ticket =  binding.code.editText?.text.toString(),
                        password = binding.password.editText?.text.toString(),
                        university = binding.universitiesDropDown.editText?.text.toString()))
        }
        binding.login.setOnClickWithDebounce {
            findNavController().navigate(RegistrationFragmentDirections.registrationToLogin())

        }
    }

    private fun validate():Boolean{
        return (binding.name.editText?.text?.isNotEmpty() == true
                && binding.code.editText?.text?.isNotEmpty() == true
                && binding.password.editText?.text?.isNotEmpty() == true
                && binding.universitiesDropDown.editText?.text?.isNotEmpty() == true)
    }
}