package org.example;

enum Tracking {
    WAITING_FOR_PAYMENT, // ожидает оплаты
    IN_PROCESSING, // ожидает подтверждения
    IS_ON_THE_WAY, // находится в пути
    DELIVERED // доставлен
}
