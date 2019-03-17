package com.teamsix.dnbxchange.view

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.camerakit.CameraKitView
import java.io.File
import java.io.FileOutputStream


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
                cameraKitView.captureImage { _, capturedImage ->
                    val savedPhoto = File(Environment.getExternalStorageDirectory(), "photo.jpg")
                    try {
                        val outputStream = FileOutputStream(savedPhoto.getPath())
                        outputStream.write(capturedImage)
                        outputStream.close()
                    } catch (e: java.io.IOException) {
                        e.printStackTrace()
                    }
                }
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
