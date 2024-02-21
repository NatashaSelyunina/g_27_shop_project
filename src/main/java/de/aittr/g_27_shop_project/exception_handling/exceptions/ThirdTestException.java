package de.aittr.g_27_shop_project.exception_handling.exceptions;

// 3 способ - создание класса-адвайса
// данный класс является глобальным обработчиком,
// который ловит исключения, выброшенные в любом месте проекта
// а также позволяет отправлять клиенту любой статус ответа
// и информативное сообщение об ошибке
public class ThirdTestException extends RuntimeException {
    public ThirdTestException(String message) {
        super(message);
    }
}