package com.example.mytestgoogle

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mytestgoogle.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status

class MainActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener
{
    private lateinit var binding:ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName
    private val RC_SIGN_IN = 7
    private var mGoogleApiClient: GoogleApiClient? = null
    private var mProgressDialog: ProgressDialog? = null

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        // Customizing G+ button
        binding.btnSignIn!!.setSize(SignInButton.SIZE_STANDARD)
        binding.btnSignIn!!.setScopes(gso.scopeArray)

        binding.btnSignIn.setOnClickListener {
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient!!)
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        binding.btnSignOut.setOnClickListener {
            Auth.GoogleSignInApi.signOut(mGoogleApiClient!!).setResultCallback(
                object : ResultCallback<Status> {
                    override fun onResult(p0: Status) {
                        updateUI(false)
                    }
                })
        }

        binding.btnRevokeAccess.setOnClickListener {
            Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient!!).setResultCallback(
                object : ResultCallback<Status> {
                    override fun onResult(p0: Status) {
                        updateUI(false)
                    }
                })
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess)
        if (result.isSuccess) {
            // Signed in successfully, show authenticated UI.
            val acct = result.signInAccount
            Log.e(TAG, "display name: " + acct!!.displayName)
            val personName = acct.displayName
            val personPhotoUrl = acct.photoUrl.toString()
            val email = acct.email
            Log.e(
                TAG, "Name: " + personName + ", email: " + email
                        + ", Image: " + personPhotoUrl
            )
            binding.txtName!!.text = personName
            binding.txtEmail!!.text = email
            Glide.with(applicationContext)
                .load(personPhotoUrl)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
            //.into(imgProfilePic)
            updateUI(true)
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false)
        }
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)
            handleSignInResult(result!!)
        }
    }

    public override fun onStart() {
        super.onStart()
        val opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient!!)
        if (opr.isDone) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in")
            val result = opr.get()
            handleSignInResult(result)
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog()
            opr.setResultCallback(object : ResultCallback<GoogleSignInResult?> {
                override fun onResult(googleSignInResult: GoogleSignInResult) {
                    hideProgressDialog()
                    handleSignInResult(googleSignInResult)
                }
            })
        }
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {

        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:$connectionResult")
    }

    @Suppress("DEPRECATION")
    private fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setMessage(null)
            mProgressDialog!!.isIndeterminate = true
        }
        mProgressDialog!!.show()
    }

    private fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.hide()
        }
    }

    private fun updateUI(isSignedIn: Boolean) {
        if (isSignedIn) {
            binding.btnSignIn!!.visibility = View.GONE
            binding.btnSignOut!!.visibility = View.VISIBLE
            binding.btnRevokeAccess!!.visibility = View.VISIBLE
            binding.llProfile!!.visibility = View.VISIBLE
        } else {
            binding.btnSignIn!!.visibility = View.VISIBLE
            binding.btnSignOut!!.visibility = View.GONE
            binding.btnRevokeAccess!!.visibility = View.GONE
            binding.llProfile!!.visibility = View.GONE
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val RC_SIGN_IN = 7
    }
}
