package com.example.ussd

class Helper {

    companion object{
        private val typeList = listOf<String>("MB", "SMS", "MIN")
        private fun changeListData(list: String):String{
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