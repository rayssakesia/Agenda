package Repository

import Entity.EntityContact

class RepositoryContact {
    companion object{
        private val contactList= mutableListOf<EntityContact>()
        fun save(contact: EntityContact){
            contactList.add(contact)
        }
        fun delete(contact:EntityContact){
            var index=0
            for(item in contactList.withIndex()){
                if(item.value.name==contact.name && item.value.phone==contact.phone){
                    index=item.index
                    break
                }
            }
            contactList.removeAt(index)
        }
        fun getList():List<EntityContact>{
            return contactList
        }
        fun getCountList():String{
            val list=getList()
            return when{
                list.isEmpty() ->"0 Contacts"
                list.size==1 -> "1 Contacts"
                else-> {
                    "${list.size} Contacts"
                }
            }
        }
    }
}