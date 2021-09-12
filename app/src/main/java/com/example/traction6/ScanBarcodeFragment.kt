package com.example.traction6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
//import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.data.Dao.CodeDao
import com.example.data.Entities.BarcodeUsers
import com.example.data.app.RoomDB.RoomApp
//import com.example.traction6.Onboarding.auth.viewModels.NewViewModel
//import com.example.traction6.Onboarding.auth.viewModels.NewViewModel
import com.example.traction6.Onboarding.auth.viewModels.SharedViewModel
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import pub.devrel.easypermissions.EasyPermissions
import kotlin.concurrent.thread


class ScanBarcodeFragment : Fragment(), EasyPermissions.PermissionCallbacks, ZXingScannerView.ResultHandler {

    private val ZXING_CAMERA_PERMISSION = 1
    lateinit var mScannerView: ZXingScannerView
    var isProductScan = false
   // private var newViewModel: NewViewModel? = null
    // private lateinit var locaDb: CodeDao

    lateinit var model: SharedViewModel

    lateinit var locaDb: RoomApp


    var onScanResult: ((String) -> Unit)? = null
    private lateinit var listener: ScanResultListener

    fun newInstance(listener: ScanResultListener): ScanBarcodeFragment{
        this.listener = listener
        return ScanBarcodeFragment()
    }


    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        super.onResume()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        activity?.onBackPressed()
    }
    override fun handleResult(rawResult: Result?) {

        val user=BarcodeUsers(0, rawResult!!.text)

        thread {
            locaDb.codeDao()?.insertUser(user)
          //  mScannerView.resumeCameraPreview(this)
            findNavController().popBackStack()
        }


       /* if (rawResult != null) {
            var newRaw = (rawResult.text)
            newRaw = newRaw + "\n" + rawResult.text
            model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            model.sendMessage(rawResult.text, newRaw)
            val barcodeUsers = BarcodeUsers(0, rawResult.text)
            newViewModel?.insertUserInfo(barcodeUsers)
            mScannerView.resumeCameraPreview(this)
            Toast.makeText(requireContext(), "$barcodeUsers", Toast.LENGTH_SHORT).show()
            Log.d("scannedres", barcodeUsers.toString())
            findNavController().popBackStack()
        }else{
            Toast.makeText(requireContext(), "wrong", Toast.LENGTH_SHORT).show()
            return
        }*/

       /* model!!.setMsgCommunicator(rawResult!!.text)
        //Launch the data receiver fragment
        val myfragment = RecyclerViewFragment()
        val fragmentTransaction = requireFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, myfragment)
        //fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        //val user = BarcodeUsers(0, rawResult.text)
       // newViewModel?.insertUserInfo(user)
           // Toast.makeText(requireContext(), "succesful", Toast.LENGTH_SHORT).show()*/




        /* rawResult?.let {
             listener.onScanResultReady(it.text)
             mScannerView.resumeCameraPreview(this)

             (parentFragment as NavHostFragment).navController.
         }*/
    }

    /* fun setScannerListener(mListener: ScanResultListener) {
     this.listener = (mListener)
    }*/

    interface ScanResultListener {
        fun onScanResultReady(barcode: String)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mScannerView = ZXingScannerView(activity)
        return mScannerView
        //val view = inflater.inflate(R.layout.fragment_s_b, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        EasyPermissions.requestPermissions(
                this, getString(R.string.rationale_camera),
                ZXING_CAMERA_PERMISSION, android.Manifest.permission.CAMERA)

        locaDb= RoomApp.getAppDatabase(requireContext())!!

    }

    override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this)
        mScannerView.isSoundEffectsEnabled = true
        mScannerView.flash = true
        mScannerView.setAspectTolerance(0.2f)
        mScannerView.startCamera()
    }

    //when activity is pause
    override fun onPause() {
        super.onPause()
        mScannerView.setResultHandler(null)
        mScannerView.stopCamera()
    }

    //when activity is destroy
    override fun onDestroy() {
        super.onDestroy()
        mScannerView.setResultHandler(null)
        mScannerView.stopCamera()
    }
}










