package formsGenerate

import Command

abstract class ListForm(title: String, ownerForm: Form? = null) : Form(title, ownerForm) {

    val content: MutableList<Form> = mutableListOf()

    abstract fun addContentAction(): Form?

    override fun generateCommandList() {

        commands.clear()

        commands[0] = Command("Создать", { addContent() })
        content.forEachIndexed { index, form ->
            commands[index + 1] = Command(form.title, { openForm(form) })
        }
        commands[content.size + 1] = Command("Выход") { back() }

    }

    fun addContent() {

        val newContent = addContentAction()
        newContent?.let { content.add(newContent) }

        display()
    }

}