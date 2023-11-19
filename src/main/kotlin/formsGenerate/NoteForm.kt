package formsGenerate

import Command

class NoteForm(title: String, var content:String, ownerForm: NotesForm):Form(title, ownerForm) {
    override fun generateCommandList() {
        commands.clear()
        commands.put(0, Command("Добавить текст", {addContent()}))
        commands.put(1, Command("Выход", {back()}))
    }

    override fun getPrewiev(): String = "ЗАМЕТКА \"${title.uppercase()}\":\n>>-----------------\n$content\n--------------------"

    fun addContent(){

        val text = EnteringCommand.inString(description = "Введите текст для добавления")
        if(text != null){
            content+="\n$text"
            display()
        }

    }

}