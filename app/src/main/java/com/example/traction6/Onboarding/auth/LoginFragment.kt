package com.example.traction6.Onboarding.auth

import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.data.cache.AppPref
import com.example.domain.exts.message
import com.example.domain.exts.observe
import com.example.domain.exts.withViewModel
import com.example.domain.states.DataResponseError
import com.example.domain.states.DataStates
import com.example.domain.states.authFailure
import com.example.domain.states.authSuccess
import com.example.traction6.Onboarding.auth.viewModels.AuthVM
import com.example.traction6.Onboarding.auth.viewModels.AuthVMFactory
import com.example.traction6.R
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_login.*
import rx.Observable
import java.util.regex.Pattern


class LoginFragment : Fragment() {
    private fun isValidInput(): Boolean {
        return Pattern.compile(".{8,}").matcher(password.text.toString())
                .find() && (android.util.Patterns.EMAIL_ADDRESS.matcher(
                email_field.text
        ).matches())
    }

    var authVM: AuthVM? = null
    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signIn.setOnClickListener {
            progressDialog = ProgressDialog(context)
            progressDialog.setCancelable(false)
            progressDialog.setMessage("authenticating user")
            progressDialog.show()

            authVM?.authUser(email_field.text.toString(), password.text.toString())

        }

        btn_back.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }



        Observable.merge(
                RxTextView.textChanges(email_field),
                RxTextView.textChanges(password)
        ).subscribe {
            signIn?.isEnabled = isValidInput()
        }

        authVM = withViewModel(AuthVMFactory) {

            observe(authentication, ::authenticationSuccessful)
            Log.d("lareed", "Called");
        }
        signIn?.isEnabled = isValidInput()
    }

    private fun authenticationSuccessful(value: DataStates?) {
        Log.d("ok", "ok");
        value?.let {
            //   progressDialog.dismiss()

            when (it) {
                is authSuccess -> {
                    progressDialog.dismiss()
                    AppPref.isAuth = true

                    Navigation.findNavController(signIn)
                            .navigate(R.id.action_loginFragment_to_recyclerViewFragment)
                }

                //if authentication is failed will show error message
                is authFailure -> {
                    progressDialog.dismiss()
                    authVM?.resetLocalAccount()
                    context?.message(it.message)
                    Toast.makeText(context, "Wrong info", Toast.LENGTH_SHORT).show()
                    return
                   // activity?.onBackPressed()
                }
                else -> context?.let { context ->
                    authVM?.resetLocalAccount()
                    (value as? DataResponseError)?.cause?.message?.let {
                        context.message(it)
                    }


                }
            }

        }
    }
}
   /* private fun checkUser() {
        //if user is already logged in go to profile Activity
        //get current user
        if (AppPref.isAuth != null){
            //user already logged in
            Navigation.findNavController(signIn)
                    .navigate(R.id.action_loginFragment_to_recyclerViewFragment)
        }
    }*/

/* val editor: SharedPreferences.Editor? = sharedpreferences?.edit()
                    if (editor != null) {
                        editor.putString(EMAIL_KEY, email_field.getText().toString())
                    }
                    if (editor != null) {
                        editor.putString(PASSWORD_KEY, password.getText().toString())
                    }
                    if (editor != null) {
                        editor.apply()
                    }*/

