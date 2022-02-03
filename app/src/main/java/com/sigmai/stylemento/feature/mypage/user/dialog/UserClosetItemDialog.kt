package com.sigmai.stylemento.feature.mypage.user.dialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.data.model.User
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetBinding
import com.sigmai.stylemento.feature.mypage.user.MyPageClosetRevisionFragment
import com.sigmai.stylemento.feature.mypage.user.MyPageUserFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.util.TransformToStringUtil

class UserClosetItemDialog(private val f : Fragment, private val owner : User, private val position: Int) : BaseDialogFragment<DialogFragmentMyPageClosetBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet
    private val item = owner.closetItems.get(position)

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@UserClosetItemDialog, 0.8f, 0.7f)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ownerCheck()
        textBinding()
    }
    private fun ownerCheck(){
        if(Client.getUserInfo().nickname != item.owner){
            binding.myPageClosetDialogDeleteText.visibility = View.INVISIBLE
            binding.myPageClosetDialogRevisionText.visibility = View.INVISIBLE
        }
        else{
            binding.myPageClosetDialogRevisionText.setOnClickListener(View.OnClickListener {
                val transaction = f.parentFragment?.parentFragmentManager?.beginTransaction()
                transaction?.replace(R.id.my_page_frameLayout, MyPageClosetRevisionFragment(item, position))
                transaction?.commit()
            })

            binding.myPageClosetDialogDeleteText.setOnClickListener(View.OnClickListener {
                var builder = AlertDialog.Builder(f.context)
                builder.setMessage("이 아이템을 삭제 하시겠습니까?")

                var listener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        when (p1) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                Client.removeClosetItem(position)
                                val transaction = f.parentFragment?.parentFragmentManager?.beginTransaction()
                                //transaction?.replace(R.id.my_page_frameLayout, MyPageUserFragment(Client.getUserInfo(), 0))
                                transaction?.commit()
                            }
                        }
                    }
                }

                builder.setPositiveButton("삭제", listener)
                builder.setNegativeButton("취소", listener)

                builder.show()
            })
        }
    }
    private fun textBinding(){
        binding.myPageClosetDialogCategoryText.text = TransformToStringUtil().getItemCategoryString(item.category)
        binding.myPageClosetDialogBrandText.text = item.brand
        binding.myPageClosetDialogItemNameText.text = item.itemName
        binding.myPageClosetDialogTextureText.text = TransformToStringUtil().getTextureString(item.texture)
        binding.myPageClosetDialogSizeText.text = item.size
        binding.myPageClosetDialogFitText.text = TransformToStringUtil().getFitString(item.myFit)
    }

}