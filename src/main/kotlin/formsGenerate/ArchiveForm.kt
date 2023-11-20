package formsGenerate

import EnteringCommand

class ArchiveForm(title: String) : ListForm(title) {

    override fun getPrewiev(): String = title.uppercase()
    override fun addContentAction(): ListForm? {

        val name = EnteringCommand.inString(
                description = "Введите наименование нового каталога")

        if (name != null) {
            return NotesForm(name, this)
        }

        return null
    }
}