package formsGenerate

import Command

abstract class ListForm(title: String, ownerForm: Form? = null):Form(title, ownerForm) {

    val content: MutableList<Form> = mutableListOf()

    abstract fun addContentAction():Form?

    override fun generateCommandList() {

        commands.clear()

        commands.put(0, Command("Создать", { addContent() }))
        var i = 1
        for (el in content) {
            commands.put(i, Command(el.title, { openForm(el) }))
            i++
        }
        commands.put(i, Command("Выход", { back() }))

    }

    fun addContent() {

        val newContent = addContentAction()
        if(newContent != null){
            content.add(newContent)
        }
        display()
    }

}