package ru.potemkin.dating.presentation


import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.yuyakaido.android.cardstackview.*
import ru.potemkin.dating.R
import ru.potemkin.dating.databinding.ActivitySwipeBinding
import ru.potemkin.dating.databinding.ItemUserBackLayoutBinding
import ru.potemkin.dating.databinding.ItemUserLayoutBinding
import ru.potemkin.dating.presentation.adapters.SwipeAdapter
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel


class SwipeActivity : AppCompatActivity() {

    private lateinit var swipeViewModel: SwipeViewModel

    private lateinit var binding: ActivitySwipeBinding
    private lateinit var swipeAdapter: SwipeAdapter

    private lateinit var manager: CardStackLayoutManager

    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var isFront = true

    private lateinit var frontCardBinding: ItemUserLayoutBinding
    private lateinit var backCardBinding: ItemUserBackLayoutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        binding = ActivitySwipeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        createManager()
        setupManager()

        swipeAdapter = SwipeAdapter()

        swipeViewModel = ViewModelProvider(this)[SwipeViewModel::class.java]
        swipeViewModel.userList.observe(this) {
            with(binding.swipe) {
                Log.d("SWIPE", it.toString())
                swipeAdapter.submitList(it)
                setLayoutManager(manager)
                setAdapter(swipeAdapter)
                setupClickListener()
                setupLongClickListener()
                setItemAnimator(DefaultItemAnimator())
            }
        }

        binding.icMatches.setOnClickListener {
            val intent = MatchesActivity.newIntentAddItem(this)
            startActivity(intent)
        }
    }

    private fun setupManager() {
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
    }

    private fun createManager() {
        manager = CardStackLayoutManager(this, object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                //Log.d("Swipe", "onCardDragging: d=" + direction?.name + " ratio=" + ratio);
            }

            override fun onCardSwiped(direction: Direction?) {
                val item = swipeAdapter.currentList[manager.topPosition-1]
                swipeViewModel.deleteMatch(item)
                Log.d("Swipe", "onCardSwiped: p=" + swipeAdapter.currentList[manager.topPosition-1] + " d=" + direction);
            }

            override fun onCardRewound() {
                //Log.d("Swipe", "onCardRewound: " + manager.topPosition);
            }

            override fun onCardCanceled() {
                //Log.d("Swipe", "onCardCancelled: " + manager.topPosition);
            }

            override fun onCardAppeared(view: View?, position: Int) {
                //Log.d("Swipe", "onCardAppeared: " + position);
            }

            override fun onCardDisappeared(view: View?, position: Int) {
                //Log.d("Swipe", "onCardDissapeared: " + swipeAdapter.currentList[position]);
            }

        })
    }

    private fun setupClickListener() {
        Log.d("Swipe", "cliock");

    }

    private fun setupLongClickListener() {
        frontCardBinding = ItemUserLayoutBinding.inflate(layoutInflater)
        backCardBinding = ItemUserBackLayoutBinding.inflate(layoutInflater)
        Log.d("Swipe", "setup");
        front_anim = AnimatorInflater.loadAnimator(
            applicationContext, R.animator.front_animator
        ) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(
            applicationContext, R.animator.back_animator
        ) as AnimatorSet
        swipeAdapter.onItemLongClickListener = {
            Log.d("Swipe", "CLICK on ${it.name}");
            if (isFront) {
                swipeAdapter.changeType()
                swipeAdapter.notifyDataSetChanged()
                isFront = false
            } else {
                swipeAdapter.changeType()
                swipeAdapter.notifyDataSetChanged()
                isFront = true
            }
        }
    }
}