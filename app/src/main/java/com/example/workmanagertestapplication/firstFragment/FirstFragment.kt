package com.example.workmanagertestapplication.firstFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.workmanagertestapplication.R
import com.example.workmanagertestapplication.database.MyDatabase
import com.example.workmanagertestapplication.database.MyRepo
import com.example.workmanagertestapplication.databinding.FragmentFirstBinding
import com.example.workmanagertestapplication.network.RetrofitInstance

class FirstFragment : Fragment() {
    private lateinit var binding : FragmentFirstBinding
    private lateinit var dataBase : MyDatabase
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first, container, false)

         val application = requireNotNull(this.activity).application
         dataBase = MyDatabase.gerInstance(application)
         val retrofit = RetrofitInstance

         val repo = MyRepo(dataBase , retrofit)

         val viewModel: MyViewModel by viewModels { MyViewModel.provideFactory(repo) }
         viewModel.refreshDataFromInternet()

         binding.xmlVariable = viewModel
         binding.lifecycleOwner = this








         return binding.root
     }
}