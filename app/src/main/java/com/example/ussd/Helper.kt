package com.example.ussd

class Helper {

    companion object{
        val traffics: List<String> = listOf("50", "100", "150", "500", "1GB", "2GB", "5GB", "10GB", "15GB ")
        val trafficsD: List<String> = listOf("50MB", "100MB", "150MB", "500MB", "1GB", "2GB", "5GB", "10GB", "15GB ")
        val sms: List<String> = listOf("50", "100", "150", "200", "250", "300", "400", "500", "600")
        val minutes: List<String> = listOf("50 Daqiqa", "100 Daqiqa", "150 Daqiqa", "200 Daqiqa", "250 Daqiqa", "300 Daqiqa", "400 Daqiqa", "500 Daqiqa", "600 Daqiqa")
        val smsD: List<String> = listOf("SMS 50", "SMS 100", "SMS 150", "SMS 200", "SMS 250", "SMS 300", "SMS 400", "SMS 500", "SMS 600")
        val titles = arrayOf("USSD", "Tarif", "Xizmat", "Minut", "Internet", "SMS")
        val icons = arrayOf(
            R.drawable.hash,
            R.drawable.credit_card,
            R.drawable.sliders,
            R.drawable.phone,
            R.drawable.earth,
            R.drawable.message
        )

        val tariffs:List<String> = listOf("Oddiy 10", "Delovoy", "Komfort", "Bolajon", "Yoshlar", "Traffic", "Traffic2")
        val textButton:List<String> = listOf("Trafikni tekshirish", "SMS ni Tekshirish", "Daqiqani Tekshirish", "Tarifni tekshirish")
        val textToolbar:List<String> = listOf("Internet paketlar", "SMS paketlar", "Daqiqalar", "Tariflar", "Xizmatlar", "USSD kodlar")
        val typeList = listOf<String>("MB", "SMS", "MIN")

        val services:List<String> = listOf(
            "LTE 4G",
            "Men kimman",
            "Menga qo'ngiroq qiling",
            "Hisobni to'ldirish",
            "Mobil anons",
            "Play mobile",
            "Ovozli pochta",
            "Raqam tanlash",
            "Uzmobile sodiqlik",
            "Aksiyalar",
            "Rouming"
        )
        val ussdCodesName:List<String> = listOf(
            "Balans",
            "Mening raqamim",
            "Menga qo'ng'iroq qiling",
            "Boshqa raqamga yo'naltirish",
            "Vaqtincha aloqada emasman",
            "Ko'ngilochar chat",
            "Men kimman",
            "Mega boom",
            "USSD kod1",
            "USSD kod2",
            "USSD kod3"
        )
        val codes:List<String> = listOf(
            "*102#",
            "*104#",
            "*144#",
            "*141#",
            "*411#",
            "*535#",
            "*111#",
            "*096#",
            "*192#",
            "*012#",
            "*500#",
        )


    }
}