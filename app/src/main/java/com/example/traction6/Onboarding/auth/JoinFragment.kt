package com.example.traction6.Onboarding.auth

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.data.cache.AppPref.isAuth
import com.example.traction6.BuildConfig
import com.example.traction6.R
import kotlinx.android.synthetic.main.fragment_join.*


class JoinFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_join, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        appGetFirstTimeRun()


        sign_in.setOnClickListener {

              findNavController()
                    .navigate(R.id.action_joinFragment_to_recyclerViewFragment)
        }


        sign_up.setOnClickListener {
            // Navigation.findNavController(it).navigate(R.id.action_joinFragment_to_recyclerActivity)
        }

    }

    private fun appGetFirstTimeRun() {
        //Check if App Start First Time
        val appPreferences: SharedPreferences = requireContext().getSharedPreferences("MyAPP", 0)
        val appCurrentBuildVersion: Int = BuildConfig.VERSION_CODE
        val appLastBuildVersion = appPreferences.getInt("app_first_time", 0)

        //Log.d("appPreferences", "app_first_time = " + appLastBuildVersion);
        if (appLastBuildVersion == appCurrentBuildVersion) {
            //return 1 //ya has iniciado la appp alguna vez
            findNavController()
                .navigate(R.id.action_joinFragment_to_recyclerViewFragment)

        } else {
            appPreferences.edit().putInt("app_first_time", appCurrentBuildVersion).apply()
            if (appLastBuildVersion == 0) {
                findNavController()
                    .navigate(R.id.action_joinFragment_to_loginFragment)

            }


        }
    }
}
