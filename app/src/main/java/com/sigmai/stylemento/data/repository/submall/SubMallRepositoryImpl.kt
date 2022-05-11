package com.sigmai.stylemento.data.repository.submall

import com.sigmai.stylemento.data.model.response.submall.SubMall
import com.sigmai.stylemento.data.model.response.submall.SubMallAll
import com.sigmai.stylemento.domain.repository.SubMallRepository
import javax.inject.Inject

class SubMallRepositoryImpl @Inject constructor(private val dataSource: SubMallDataSource) : SubMallRepository {
    override fun deleteSubMall(crdiEmail : String) : Boolean {
        return dataSource.deleteSubMall(crdiEmail)
    }
    override fun getSubMall(crdiEmail : String) : SubMall {
        return dataSource.getSubMall(crdiEmail)
    }
    override fun postSubMall(bank : String, accountNumber : String, holderName : String, crdiEmail : String, companyName : String, representativeName : String, type : String, businessNumber : String) : SubMall {
        return dataSource.postSubMall(bank, accountNumber, holderName, crdiEmail, companyName, representativeName, type, businessNumber)
    }
    override fun putSubMall(crdiEmail : String, bank : String, accountNumber : String, holderName : String, companyName : String, representativeName : String, businessNumber : String) : SubMall {
        return dataSource.putSubMall(crdiEmail, bank, accountNumber, holderName, companyName, representativeName, businessNumber)
    }
    override fun getSubMallAll() : List<SubMallAll>{
        return dataSource.getSubMallAll()
    }
}