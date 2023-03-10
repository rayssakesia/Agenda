package Business
import java.lang.Exception
class ContactBusiness {
    fun validate(name:String,phone:String){ //variaveis necessarias para  fazer a validaçao
     if(name==" "){
      throw Exception ("Name is required")
   }
        if(phone==" "){
            throw Exception ("Phone Number is required") // joga uma exceçao para o usuario saber porque deu erro
        }
     }
    fun validateDelete(name:String,phone: String){
        if(name==" "|| phone==" "){
            throw Exception("You must choose at least one contact to be able to delete")
        }
    }
    fun save(name:String,phone: String){
        validate(name,phone)
    }
    fun delete(name:String,phone: String){
        validateDelete(name,phone)
    }
}