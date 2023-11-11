## Приложение, выполенное по тестовому заданию
Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.
Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

## Основные технологии
- Java,
- Maven,
- Spring (Boot, Web, Test)

## End points
- /service/string
  метод POST
 Пример запроса:
  header: 'Content-Type: text/plain'
  body: “aaaaabcccc”
 Пример ответа:
```
{
	"a": 5,
	"c": 4,
	"b": 1
}
```

Пример curl:

curl --location --request POST 'http://localhost:8080/service/string' \
--header 'Content-Type: text/plain' \
--data-raw 'aaaaabcccc'


## Инструкция по запуску в IDE Intellij IDEA

1. Загрузить зависимости с помощью Maven.
2. Запустить тесты: ToneApplicationTests.java
3. Запустить приложение: ToneApplication.java



