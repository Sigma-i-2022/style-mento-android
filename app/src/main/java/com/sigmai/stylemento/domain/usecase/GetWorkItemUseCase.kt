package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.LookbookItem
import com.sigmai.stylemento.data.model.WorkItem

class GetWorkItemUseCase {
    operator fun invoke(position: Int) : WorkItem {
        return Client.getCoordinatorInfo().workItems[position]
    }
}