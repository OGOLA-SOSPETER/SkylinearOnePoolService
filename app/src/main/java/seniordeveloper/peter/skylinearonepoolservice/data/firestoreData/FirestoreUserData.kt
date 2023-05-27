package seniordeveloper.peter.skylinearonepoolservice.data.firestoreData

data class FirestoreUserData(val userId:String, val userName:String, val userAge:String, val userDescription:String, val userLocation:String, val userPrice: Float?){
    constructor():this("","","","","",null)
}
