package com.sigmai.stylemento.global.component

import android.content.Context
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
            rootView?.findViewById<ImageButton>(R.id.edit_profile)?.visibility =
                if (value) View.VISIBLE else View.GONE
        }

    private var textButtonName: String = "완료"
        set(value) {
            field = value
            rootView?.findViewById<Button>(R.id.text_button)?.text = value
        }

    private var showBackButton: Boolean = false
    private var showTextButton: Boolean = false
    private var showSettingsButton: Boolean = false

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
                showTextButton = getBoolean(R.styleable.SmToolbar_showTextButton, false)
                showBackButton = getBoolean(R.styleable.SmToolbar_showBackButton, false)
                showSettingsButton = getBoolean(R.styleable.SmToolbar_showSettingsButton, false)
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
        val textButton = findViewById<Button>(R.id.text_button)
        val settingsButton = findViewById<View>(R.id.settings)

        titleTextView.text = title
        backButton.visibility = if (showBackButton) View.VISIBLE else View.GONE
        editButton.visibility = if (isMyPage) View.VISIBLE else View.GONE
        textButton.visibility = if (showTextButton) View.VISIBLE else View.GONE
        settingsButton.visibility = if (showSettingsButton) View.VISIBLE else View.GONE
    }

    fun setOnBackListener(action: (view: View) -> Unit) {
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnEditListener(action: (view: View) -> Unit) {
        val editButton = findViewById<ImageButton>(R.id.edit_profile)
        editButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnFinishListener(action: (view: View) -> Unit) {
        val textButton = findViewById<Button>(R.id.text_button)
        textButton.setOnClickListener {
            action(it)
        }
    }

    fun setOnSettingsListener(action: (view: View) -> Unit) {
        val settingsButton = findViewById<View>(R.id.settings)
        settingsButton.setOnClickListener {
            action(it)
        }
    }

    override fun setTitle(title: CharSequence?) {
        this.title = title.toString()
    }

    fun setIsMyPage(isMyPage: Boolean) {
        this.isMyPage = isMyPage
    }

    @JvmName("setTextButtonName1")
    fun setTextButtonName(textButtonName: String) {
        this.textButtonName = textButtonName
    }
}