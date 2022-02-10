package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem

class GetLookbookItemUseCase {
    operator fun invoke(position: Int) : LookbookItem {
        return Client.getUserInfo().lookbookItems[position]
    }
}