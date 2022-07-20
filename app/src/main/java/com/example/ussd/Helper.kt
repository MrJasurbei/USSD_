package com.example.ussd

class Helper {

    companion object{
        val traffics: List<String> = listOf("50", "100", "150", "500", "1GB", "2GB", "5GB", "10GB", "15GB ")
        val sms: List<String> = listOf("50", "100", "150", "200", "250", "300", "400", "500", "600")
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
        val textToolbar:List<String> = listOf("Internet paketlar", "SMS paketlar", "Daqiqalar", "Tariflar")
         val typeList = listOf<String>("MB", "SMS", "MIN")
         fun changeListData(list: String):String{
            var text = ""
            for (i in typeList.indices){
                if (!list.contains('G')){
                    text = list + typeList[i]
                }
                else text = list
            }

            return text
        }
    }
}