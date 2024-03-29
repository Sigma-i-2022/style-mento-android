package com.sigmai.stylemento.global.component

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sigmai.stylemento.R

class SmBottomSheet(context: Context?) : ConstraintLayout(context!!) {
    val dialog: BottomSheetDialog

    init {
        initView()
        dialog = BottomSheetDialog(context!!)
    }

    private fun initView() {
        inflate(context, R.layout.view_bottom_sheet, this)
    }

    fun setOnClickListener(onEdit: (view: View) -> Unit, onDelete: (view: View) -> Unit) {
        val editButton = findViewById<TextView>(R.id.edit)
        val deleteButton = findViewById<TextView>(R.id.delete)

        editButton.setOnClickListener {
            onEdit(it)
            dialog.dismiss()
        }

        deleteButton.setOnClickListener {
            onDelete(it)
            dialog.dismiss()
        }
    }

    fun show() {
        dialog.setContentView(rootView)
        dialog.show()
    }
}