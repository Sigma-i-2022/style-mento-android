package com.sigmai.stylemento.ui.mypage.user.viewModel

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.domain.usecase.GetLookbookItemUseCase
import com.sigmai.stylemento.global.util.SingleLiveEvent
import com.sigmai.stylemento.ui.mypage.user.adapter.UserLookbookItemAdapter2

class MyPageLookbookScrollViewModel : ViewModel() {
    val startBack = SingleLiveEvent<Any>()
    var position = MutableLiveData(0)

    fun onBackClick(){
        startBack.call()
    }

    fun onClickRevision(view: View, position: Int) {
        val bundle = bundleOf("position" to position)
        view.findNavController().navigate(R.id.action_lookbook_scroll_to_lookbook_add, bundle)
    }

    fun setDeleteDialog(
        it: View,
        position: Int
    ) {
        val builder = AlertDialog.Builder(it.context)
        builder.setMessage("이 아이템을 삭제 하시겠습니까?")

        val listener = DialogInterface.OnClickListener { p0, p1 ->
            when (p1) {
                DialogInterface.BUTTON_POSITIVE -> {
                    updateAdapterAfterDeleteLookbook(position)
                }
            }
        }

        builder.setPositiveButton("삭제", listener)
        builder.setNegativeButton("취소", listener)

        builder.show()
    }

    private fun updateAdapterAfterDeleteLookbook(position : Int) {
        Client.removeLookbookItem(position)
        this.position.value = position - 1
    }
}