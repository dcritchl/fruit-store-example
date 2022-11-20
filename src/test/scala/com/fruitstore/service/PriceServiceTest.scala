package com.fruitstore.service

import com.fruitstore.model.{Apple, Orange}
import org.scalatest._
import flatspec._
import matchers._

class PriceServiceTest extends AnyFlatSpec with should.Matchers {
  "getPriceInPence" should "return the price of an Apple" in {
    PriceService.getPriceInPence(Apple) should be(60)
  }

  "getPriceInPence" should "return the price of an Orange" in {
    PriceService.getPriceInPence(Orange) should be(25)
  }
}
