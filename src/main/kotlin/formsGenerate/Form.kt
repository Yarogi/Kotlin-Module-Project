package formsGenerate

import Command

abstract class Form(val title: String, val ownerForm: Form? = null) {

    val commands: MutableMap<Int, Command> = mutableMapOf()

    abstract fun generateCommandList()

    abstract fun getPrewiev(): String

    fun display() {
        generateCommandList()
        EnteringCommand.commandEntry(getPrewiev(), commands)
    }

    fun openForm(element: Form) {
        element.display()
    }

    fun back() {
        ownerForm?.display()
    }
}