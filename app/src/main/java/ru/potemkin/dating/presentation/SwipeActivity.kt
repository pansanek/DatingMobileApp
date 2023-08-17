package ru.potemkin.dating.presentation


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import com.yuyakaido.android.cardstackview.*
import ru.potemkin.dating.R
import ru.potemkin.dating.databinding.ActivitySwipeBinding
import ru.potemkin.dating.presentation.adapters.SwipeAdapter
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel


class SwipeActivity : AppCompatActivity() {

    var flingAdapterView: SwipeFlingAdapterView? = null
    private lateinit var swipeViewModel: SwipeViewModel

    private lateinit var binding: ActivitySwipeBinding
    private lateinit var swipeAdapter: SwipeAdapter

    private lateinit var manager: CardStackLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        binding = ActivitySwipeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        manager = CardStackLayoutManager(this,object: CardStackListener{
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                Log.d("Swipe", "onCardDragging: d=" + direction?.name + " ratio=" + ratio);
            }

            override fun onCardSwiped(direction: Direction?) {
                Log.d("Swipe", "onCardSwiped: p=" + manager?.topPosition + " d=" + direction);
            }

            override fun onCardRewound() {
                Log.d("Swipe", "onCardRewound: " + manager?.topPosition);
            }

            override fun onCardCanceled() {
                Log.d("Swipe", "onCardCancelled: " + manager?.topPosition);
            }

            override fun onCardAppeared(view: View?, position: Int) {
                Log.d("Swipe", "onCardAppeared: " + position);
            }

            override fun onCardDisappeared(view: View?, position: Int) {
                Log.d("Swipe", "onCardDisappeared: " + position);
            }

        })
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.FREEDOM)
        manager.setCanScrollHorizontal(true)
        manager.setSwipeableMethod(SwipeableMethod.Manual)
        manager.setOverlayInterpolator(LinearInterpolator())


        swipeViewModel = ViewModelProvider(this)[SwipeViewModel::class.java]
        swipeViewModel.userList.observe(this) {
            with(binding.swipe) {
                val adapter = SwipeAdapter(it)
                setLayoutManager(manager)
                setAdapter(adapter)
                setItemAnimator(DefaultItemAnimator())
            }
        }
    }
}