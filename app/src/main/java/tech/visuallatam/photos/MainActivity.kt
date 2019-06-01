package tech.visuallatam.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.photos.adapter.adapter
import tech.visuallatam.photos.database.viewmodel.photoViewModel

class MainActivity : AppCompatActivity() {

    lateinit var adapter: adapter
    lateinit var viewModel: photoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    fun bind(){
        adapter = adapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(photoViewModel::class.java)
        recycler.apply{
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
        viewModel.todos().observe(this, Observer{
            adapter.updateList(it)
        })
        button.setOnClickListener {
            viewModel.getstuff()
        }
    }
}
