# ExpenseFlow
Микросервис для учёта совместных расходов и автоматического расчёта взаиморасчетов.
Система позволяет создавать группы участников, фиксировать расходы и автоматически рассчитывать, кто кому сколько должен. Интеграция через Telegram Bot.

## Возможности

- Идентификация по Telegram ID — без паролей и регистрации
- Мультигрупповость: один пользователь может состоять в нескольких группах
- Два типа расходов:
  SPLIT — общие покупки (сумма делится между участниками)
  ASSIGN — целевые покупки (полная сумма списывается с конкретного участника)
- Асинхронные уведомления через RabbitMQ
- Мониторинг бизнес-метрик в Grafana

## Технологический стек
Java 21, Spring Boot 3, PostgreSQL, RabbitMQ, Prometheus + Grafana, Telegram Bot, Docker + Docker Compose

## Быстрый старт
Требования

    - Docker и Docker Compose
    - Java 21 (для локальной разработки)

## Запуск инфраструктуры
```bash
docker-compose up -d
```
Поднимет: PostgreSQL, RabbitMQ, Prometheus, Grafana.

## Запуск приложения
```bash
./mvnw spring-boot:run
```

## Настройка Telegram Bot
- Создайте бота через @BotFather
- Получите токен
- Добавьте в application.yml:

```yaml
telegram:
  bot:
    token: YOUR_BOT_TOKEN
```

## Использование (Telegram Bot)

| Команда  | Описание |
| ------------- | ------------- |
| /start  | Регистрация/главное меню  |
| /add 1000 Продукты  | Добавить общий расход (SPLIT)  |
| /add 500 Билет для @user  | Добавить целевой расход (ASSIGN)  |
| /balance  | Показать текущий баланс группы  |
| /settle @user 500  | Зафиксировать погашение долга  |
| /history  | История расходов  |

## Мониторинг
Prometheus: http://localhost:9090

Grafana: http://localhost:3000 (логин/пароль: admin/admin)

## Ключевые метрики:
- expenses_total_amount — общая сумма расходов
- outstanding_debt_total — сумма непогашенных долгов
- active_users_count — активные пользователи

## Тесты
```bash
./mvnw test
```

Интеграционные тесты используют Testcontainers для поднятия тестовой БД.

## Лицензия
Apache License 2.0 — см. файл LICENSE
