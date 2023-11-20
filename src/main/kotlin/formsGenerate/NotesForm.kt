package formsGenerate

class NotesForm(title: String, ownerForm: ArchiveForm) : ListForm(title, ownerForm) {

    override fun getPrewiev(): String = "ЗАМЕТКИ АРХИВА \"${title.uppercase()}\""

    override fun addContentAction(): Form? {
        val name = EnteringCommand.inString("Введите имя новой заметки")
        if (name != null) {
            val text = EnteringCommand.inString("Введите содержимое заметки")
            if (text != null) {
                val newNote = NoteForm(title = name, content = text, ownerForm = this)
                return newNote
            }
        }
        return null
    }

}