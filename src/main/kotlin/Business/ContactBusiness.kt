package Business
import Entity.EntityContact
import Repository.RepositoryContact
import java.lang.Exception
class ContactBusiness {
    fun validate(name:String,phone:String){
     if(name==""){
      throw Exception ("Name is required")
   }
        if(phone==""){
            throw Exception ("Phone Number is required")
        }
     }
    fun validateDelete(name:String,phone: String){
        if(name==""|| phone==""){
            throw Exception("You must choose at least one contact to be able to delete")
        }
    }
    fun save(name:String,phone: String){
        validate(name,phone)
        val contact=EntityContact(name,phone)
        RepositoryContact.save(contact)
    }
    fun delete(name:String,phone: String){
        validateDelete(name,phone)
        val contact=EntityContact(name,phone)
        RepositoryContact.delete(contact)
    }
    fun getList():List<EntityContact>{
        return RepositoryContact.getList()
    }
    fun getCountList():String{
        return RepositoryContact.getCountList()
    }
}