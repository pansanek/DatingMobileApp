package ru.potemkin.dating.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.potemkin.dating.R
import ru.potemkin.dating.databinding.ActivityMatchesBinding
import ru.potemkin.dating.presentation.adapters.MatchesAdapter
import ru.potemkin.dating.presentation.viewmodels.MatchesViewModel

class MatchesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchesBinding
    private lateinit var viewModel: MatchesViewModel
    private lateinit var matchesAdapter: MatchesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupSwitch()
        viewModel = ViewModelProvider(this).get(MatchesViewModel::class.java)
        viewModel.userList.observe(this) {
            matchesAdapter.submitList(it)
            Log.d("TAG", it.toString())
        }

    }

    private fun setupSwitch() {
        with(binding) {
            switchOnOff.setOnCheckedChangeListener { _, checked ->
                when {
                    checked -> {
                        tvSwitchYes.setTextColor(
                            ContextCompat.getColor(
                                applicationContext,
                                R.color.teal_200
                            )
                        )
                        matchesAdapter.changeType()
                        matchesAdapter.notifyDataSetChanged()
                        tvSwitchNo.setTextColor(
                            ContextCompat.getColor(
                                applicationContext, R.color.white
                            )
                        )
                    }
                    else -> {
                        tvSwitchYes.setTextColor(
                            ContextCompat.getColor(
                                applicationContext, R.color.white
                            )
                        )
                        matchesAdapter.changeType()
                        matchesAdapter.notifyDataSetChanged()
                        tvSwitchNo.setTextColor(
                            ContextCompat.getColor(
                                applicationContext, R.color.teal_200
                            )
                        )
                    }
                }
            }
        }
    }

    private fun setupSwipeListener(recyclerView: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = matchesAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteMatch(item)
                Toast.makeText(
                    this@MatchesActivity,
                    "User ${item.name} is deleted from matches",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupClickListener() {
        matchesAdapter.onItemClickListener = {
            Toast.makeText(
                this@MatchesActivity,
                "User ${it.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            matchesAdapter = MatchesAdapter()
            adapter = matchesAdapter
            recycledViewPool.setMaxRecycledViews(
                MatchesAdapter.VIEW_TYPE_MATCHES,
                MatchesAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                MatchesAdapter.VIEW_TYPE_MESSAGE,
                MatchesAdapter.MAX_POOL_SIZE
            )
        }
//        setupLongClickListener()
        setupClickListener()
        setupSwipeListener(binding.recyclerView)
    }


    companion object {

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, MatchesActivity::class.java)
            //intent.putExtra(MODE_ADD) - при мэтче на главном экране сразу переход к чаты
            return intent
        }
    }
}