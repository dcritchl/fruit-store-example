package com.fruitstore.service

import com.fruitstore.model.{Apple, Fruit, Orange}

object SpecialOffersService {
  def getFruitSubtotal(fruit: Fruit, numberOfFruit: Int): Int = fruit match {
    case Apple =>
      (numberOfFruit / 2 + numberOfFruit % 2) * PriceService.getPriceInPence(Apple)
    case Orange =>
      ((numberOfFruit / 3) * 2 + numberOfFruit % 3) * PriceService.getPriceInPence(Orange)
  }
}
