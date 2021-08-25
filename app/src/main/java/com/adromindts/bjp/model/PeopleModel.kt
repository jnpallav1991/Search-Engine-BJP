package com.adromindts.bjp.model

data class PeopleModel(
    val Sheet1 : ArrayList<Sheet>
) {
    data class Sheet(
        val CCODE:String?,
        val Address: String?,
        val Age: String?,
        val EPICNo: String?,
        val ElectorPhoto: String?,
        val Gender: String?,
        val NameOfElector: String?,
        val Occupation: String?,
        val Qualification: String?,
        val RelativeName: String?,
        val SrNo : String?,
        val NameOfElectorMarathi:String?,
        val GPART_NO:String?
    )


}