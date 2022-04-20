package com.sigmai.stylemento.ui.reservation

import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ViewPrivacyDialogBinding
import com.sigmai.stylemento.databinding.ViewReservationInfoDialogBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment

class InfoDialogFragment : BaseDialogFragment<ViewReservationInfoDialogBinding>() {
    override val layoutResourceId = R.layout.view_reservation_info_dialog
    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@InfoDialogFragment, 0.8f, 0.8f)
    }
}