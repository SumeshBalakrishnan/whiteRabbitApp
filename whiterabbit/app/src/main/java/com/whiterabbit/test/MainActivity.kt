package com.whiterabbit.test

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.whiterabbit.test.db.dao.UserDao
import com.whiterabbit.test.db.dataBase.AppDatabase
import com.whiterabbit.test.emitter.Status
import com.whiterabbit.test.model.Response
import com.whiterabbit.test.network.ApiHelper
import com.whiterabbit.test.network.RetrofitBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    private var db: AppDatabase? = null
    private var genderDao: UserDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initDB()
        setupUI()
        setupViewModel()
        setupObservers()


    }

    private fun initDB() {
        Observable.fromCallable {
            db = AppDatabase.getAppDataBase(context = this)
            genderDao = db?.userDao()

        }.doOnNext { list ->
            var finalString = list
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(
                        ApiHelper(
                                RetrofitBuilder.apiService
                        )
                )
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users ->
                            with(genderDao) {
                                this?.insertUser(users)
                            }
                            retrieveList(users)
                        }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<Response>) {
        adapter.apply {

            var a = db?.userDao()?.getUsers()

            addUsers(users)
            notifyDataSetChanged()
        }
    }
}
