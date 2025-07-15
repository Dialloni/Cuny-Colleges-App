package com.example.cunymapapp

import android.content.Context
import android.location.Geocoder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import java.util.*

class MapFragment : Fragment() {

    private var address: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        address = arguments?.getString("address")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync { googleMap ->
            val location = getLatLongFromAddress(requireContext(), address ?: "")
            location?.let {
                googleMap.addMarker(MarkerOptions().position(it).title("Here"))
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 16f))
            }
        }
    }

    private fun getLatLongFromAddress(context: Context, address: String): LatLng? {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val result = geocoder.getFromLocationName(address, 1)
            if (!result.isNullOrEmpty()) LatLng(result[0].latitude, result[0].longitude) else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
