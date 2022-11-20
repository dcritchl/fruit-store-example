package com.fruitstore.service

import com.fruitstore.model.{Apple, Fruit, Orange}

object CheckoutService {
  def getBasketTotalPrice(basket: List[Fruit]): Int = {
    // split into Apples and Oranges
    val groups = basket.groupBy {
      case Apple => Apple
      case Orange => Orange
    }

    // sum the cost for each type of fruit
    groups.map { entry =>
      val (fruit, listOfFruit) = entry
      PriceService.getPriceInPence(fruit) *  listOfFruit.size
    }.sum
  }
}
