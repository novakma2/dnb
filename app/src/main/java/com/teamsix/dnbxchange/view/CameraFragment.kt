package com.teamsix.dnbxchange.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.camerakit.CameraKitView
import com.teamsix.dnbxchange.DataAccess
import java.lang.Thread.sleep


class CameraFragment : Fragment() {
    private var cameraKitView: CameraKitView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.teamsix.dnbxchange.R.layout.fragment_camera, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cameraKitView = view?.findViewById(com.teamsix.dnbxchange.R.id.camera)
        cameraKitView?.gestureListener = object : CameraKitView.GestureListener {
            override fun onTap(cameraKitView: CameraKitView, v: Float, v1: Float) {
            }

            override fun onLongTap(cameraKitView: CameraKitView, v: Float, v1: Float) {
                Toast.makeText(context, "Analyzing photo", Toast.LENGTH_SHORT).show()
                sleep(2500)
                DataAccess.sharedValue.number.postValue(39.90.toBigDecimal())
            }

            override fun onDoubleTap(cameraKitView: CameraKitView, v: Float, v1: Float) {
            }

            override fun onPinch(cameraKitView: CameraKitView, v: Float, v1: Float, v2: Float) {
            }
        }
    }

    override fun onStart() {
        cameraKitView?.onStart()
        super.onStart()
    }

    override fun onResume() {
        cameraKitView?.onResume()
        super.onResume()
    }

    override fun onPause() {
        cameraKitView?.onPause()
        super.onPause()
    }

    override fun onStop() {
        cameraKitView?.onStop()
        super.onStop()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        cameraKitView?.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
