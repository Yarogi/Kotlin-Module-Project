class Command(val name:String, val action:()->Unit){
    fun execute(){
        action()
    }
}