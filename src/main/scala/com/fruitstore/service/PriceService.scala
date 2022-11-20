package com.fruitstore.service

import com.fruitstore.model.{Apple, Fruit, Orange}

object PriceService {
  def getPriceInPence(fruit: Fruit): Int = fruit match {
    case Apple => 60
    case Orange => 25
  }
}
