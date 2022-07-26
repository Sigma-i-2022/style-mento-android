package com.sigmai.stylemento.data.repository.payment

import com.sigmai.stylemento.data.api.PaymentService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.Payment
import com.sigmai.stylemento.data.model.PaymentFail
import com.sigmai.stylemento.data.model.PaymentItem
import com.sigmai.stylemento.data.model.PaymentSuccess
import javax.inject.Inject

class PaymentDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<PaymentService>()

    fun postPayment(reservationSeq : Long, payType : String, amount : Long, orderName : String, customerEmail : String, customerName : String) : Payment{
        return service.postPayment(reservationSeq, payType, amount, orderName, customerEmail, customerName).execute().body()!!.data
    }
    fun getPaymentList(email : String, page : Int, size : Int) : List<PaymentItem>{
        return service.getPaymentList(email, page, size).execute().body()!!.data
    }
    fun getPaymentFail(code : String, message : String, orderId : String) : PaymentFail{
        return service.getPaymentFail(code, message, orderId).execute().body()!!.data
    }
    fun getPaymentSuccess(paymentKey : String, orderId : String, amount : Long) : PaymentSuccess{
        return service.getPaymentSuccess(paymentKey, orderId, amount).execute().body()!!.data
    }
    fun postVirtualIncome(secret : String, status : String, orderId : String) : Boolean{
        return service.postVirtualIncome(secret, status, orderId).execute().body()?.success ?: false
    }
    fun postWebHook(paymentKey : String, status : String, orderId : String, paymentSeq : Long, eventType : String) : Boolean{
        return service.postWebHook(paymentKey, status, orderId, paymentSeq, eventType).execute().body()?.success ?: false
    }
}