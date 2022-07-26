package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.Payment
import com.sigmai.stylemento.data.model.PaymentFail
import com.sigmai.stylemento.data.model.PaymentItem
import com.sigmai.stylemento.data.model.PaymentSuccess

interface PaymentRepository {
    fun postPayment(reservationSeq : Long, payType : String, amount : Long, orderName : String, customerEmail : String, customerName : String) : Payment
    fun getPaymentList(email : String, page : Int, size : Int) : List<PaymentItem>
    fun getPaymentFail(code : String, message : String, orderId : String) : PaymentFail
    fun getPaymentOne(email : String, reservationSeq : Long) : PaymentItem
    fun getPaymentSuccess(paymentKey : String, orderId : String, amount : Long) : PaymentSuccess
    fun postVirtualIncome(secret : String, status : String, orderId : String) : Boolean
    fun postWebHook(paymentKey : String, status : String, orderId : String, paymentSeq : Long, eventType : String) : Boolean
}