package ru.potemkin.dating.presentation


import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import ru.potemkin.dating.databinding.ActivitySwipeBinding
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel
import ru.potemkin.dating.R



class SwipeActivity : AppCompatActivity() {

    private var arrayAdapter: ArrayAdapter<String>? = null
    var flingAdapterView: SwipeFlingAdapterView? = null
    private lateinit var swipeViewModel: SwipeViewModel
    private var data = ArrayList<String>()

    private lateinit var viewModel: SwipeViewModel
    private lateinit var binding: ActivitySwipeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        binding = ActivitySwipeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        swipeViewModel = ViewModelProvider(this)[SwipeViewModel::class.java]

        flingAdapterView = binding.swipe
        swipeViewModel.userList.observe(this) {
            for(i in 0..it.size-1){
                data.add(it[i].toString())
                Log.d("MainActivityTest", "List:" + data[i])
            }
            arrayAdapter =
                ArrayAdapter<String>(this, R.layout.item_user_layout, R.id.textView3, data)
            binding.swipe.adapter = arrayAdapter
            binding.swipe.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
                override fun removeFirstObjectInAdapter() {
                    data.removeAt(0)
                    arrayAdapter?.notifyDataSetChanged()
                }

                override fun onLeftCardExit(p0: Any?) {
                    Log.d("MainActivityTest","left")
                }

                override fun onRightCardExit(p0: Any?) {
                    Log.d("MainActivityTest","right")
                }

                override fun onAdapterAboutToEmpty(p0: Int) {
                    Log.d("MainActivityTest","AdapterAboutToEmpty")
                }

                override fun onScroll(p0: Float) {

                }

            })
        }
    }
}