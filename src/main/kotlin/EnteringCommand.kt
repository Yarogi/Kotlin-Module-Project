import java.util.Scanner

object EnteringCommand {

    fun inString(description: String, useBreack: Boolean = true, breakWord: String = "Отмена"): String? {

        var result: String? = null

        var value: String = ""
        while (true) {

            println(description)
            if (breakWord != null) {
                println("Для отмены введите \"$breakWord\"")
            }

            value = Scanner(System.`in`).nextLine()
            if (value.isEmpty()) {
                println("Значение не может быть пустым!")
                continue
            }
            break
        }

        if (!useBreack || breakWord.lowercase() != value.lowercase()) {
            result = value
        }

        return result

    }

    fun commandEntry(title: String, commands: MutableMap<Int, Command>) {
        while (true) {

            println("$title:")
            println("Выберите дальнейшее действие:")
            for ((key, command) in commands) {
                println("$key. ${command.name}")
            }

            var command: Command? = null
            val scanner = Scanner(System.`in`)
            if (scanner.hasNextInt()) {
                command = commands[scanner.nextInt()]
            }

            if (command == null) {
                println("Введена неверная команда: команда должна быть числом в диапазоне списка")
            } else {
                command.execute()
                break
            }

        }
    }
}