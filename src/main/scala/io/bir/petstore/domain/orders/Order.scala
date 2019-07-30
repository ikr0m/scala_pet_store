package io.bir.petstore.domain.orders

import java.time.Instant

case class Order(
                petId: Long,
                shipData: Option[Instant] = None,
                status: OrderStatus = OrderStatus.Placed,
                complete: Boolean = false,
                id: Option[Long] = None,
                userId: Option[Long]
                )