package com.teamsix.dnbxchange.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.camerakit.CameraKitView
import com.teamsix.dnbxchange.R


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
        cameraKitView = view?.findViewById(R.id.camera)
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
