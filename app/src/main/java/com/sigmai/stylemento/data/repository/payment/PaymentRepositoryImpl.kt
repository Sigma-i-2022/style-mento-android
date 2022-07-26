package com.sigmai.stylemento.data.repository.payment

import com.sigmai.stylemento.data.model.Payment
import com.sigmai.stylemento.data.model.PaymentFail
import com.sigmai.stylemento.data.model.PaymentItem
import com.sigmai.stylemento.data.model.PaymentSuccess
import com.sigmai.stylemento.domain.repository.PaymentRepository
import javax.inject.Inject

class PaymentRepositoryImpl @Inject constructor(private val dataSource: PaymentDataSource) : PaymentRepository {
    override fun postPayment(reservationSeq : Long, payType : String, amount : Long, orderName : String, customerEmail : String, customerName : String) : Payment {
        return dataSource.postPayment(reservationSeq, payType, amount, orderName, customerEmail, customerName)
    }
    override fun getPaymentList(email : String, page : Int, size : Int) : List<PaymentItem>{
        return dataSource.getPaymentList(email, page, size)
    }
    override fun getPaymentOne(email: String, reservationSeq: Long): PaymentItem {
        return dataSource.getPaymentOne(email, reservationSeq)
    }
    override fun getPaymentFail(code : String, message : String, orderId : String) : PaymentFail {
        return dataSource.getPaymentFail(code, message, orderId)
    }
    override fun getPaymentSuccess(paymentKey : String, orderId : String, amount : Long) : PaymentSuccess {
        return dataSource.getPaymentSuccess(paymentKey, orderId, amount)
    }
    override fun postVirtualIncome(secret : String, status : String, orderId : String) : Boolean{
        return dataSource.postVirtualIncome(secret, status, orderId)
    }
    override fun postWebHook(paymentKey : String, status : String, orderId : String, paymentSeq : Long, eventType : String) : Boolean{
        return dataSource.postWebHook(paymentKey, status, orderId, paymentSeq, eventType)
    }
}