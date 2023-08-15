package ru.potemkin.dating.presentation.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import ru.potemkin.dating.databinding.FragmentSwipeBinding
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel


class SwipeFragment : Fragment() {

    private var arrayAdapter: ArrayAdapter<String>? = null
    var flingAdapterView: SwipeFlingAdapterView? = null
    private lateinit var swipeViewModel: SwipeViewModel

    private val viewModel by lazy {
        ViewModelProvider(this)[SwipeViewModel::class.java]
    }

    private  var _binding:FragmentSwipeBinding?=null
    private val binding: FragmentSwipeBinding
        get()=_binding?:throw java.lang.RuntimeException("FragmentSwipeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSwipeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeViewModel = ViewModelProvider(this)[SwipeViewModel::class.java]
        swipeViewModel.userList.observe(viewLifecycleOwner){

        }
        binding.swipe
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
