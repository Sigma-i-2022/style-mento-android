package com.sigmai.stylemento.global.component

import android.content.Context
import android.media.Image
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.sigmai.stylemento.R

class SmToolbar(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {
    private var title: String = ""
        set(value) {
            field = value
            rootView?.findViewById<TextView>(R.id.title)?.text = value
        }

    private var isMyPage: Boolean = false
        set(value) {
            field = value
            rootView?.findViewById<ImageButton>(R.id.edit_profile)?.visibility = if(value) View.VISIBLE else View.GONE
        }

    private var showBackButton: Boolean = false

    init {
        initAttrs(attrs)
        initView()
    }

    private fun initAttrs(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SmToolbar,
            0, 0
        ).apply {
            try {
                showBackButton = getBoolean(R.styleable.SmToolbar_showBackButton, false)
                isMyPage = getBoolean(R.styleable.SmToolbar_isMyPage, false)
                title = getString(R.styleable.SmToolbar_title) ?: ""
            } finally {
                recycle()
            }
        }
    }

    private fun initView() {
        inflate(context, R.layout.view_toolbar, this)

        val titleTextView = findViewById<TextView>(R.id.title)
        val backButton = findViewById<Button>(R.id.back_button)
        val editButton = findViewById<ImageButton>(R.id.edit_profile)

        titleTextView.text = title
        backButton.visibility = if(showBackButton) View.VISIBLE else View.GONE
        editButton.visibility = if(isMyPage) View.VISIBLE else View.GONE
    }

    fun setOnBackListener(action: (view: View)->Unit) {
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnEditListener(action: (view: View)->Unit) {
        val editButton = findViewById<ImageButton>(R.id.edit_profile)
        editButton.setOnClickListener {
            action(it)
        }
    }

    override fun setTitle(title: CharSequence?) {
        this.title = title.toString()
    }

    fun setIsMyPage(isMyPage: Boolean) {
        this.isMyPage = isMyPage
    }
}