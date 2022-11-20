package com.fruitstore.service

import com.fruitstore.model.{Apple, Orange}
import org.scalatest._
import flatspec._
import matchers._

class SpecialOffersServiceTest extends AnyFlatSpec with should.Matchers {
  "getFruitSubtotal" should "return a simple addition for Apple count 1 item" in {
    SpecialOffersService.getFruitSubtotal(Apple, 1) should be (PriceService.getPriceInPence(Apple))
  }

  "getFruitSubtotal" should "return a two for 1 discount for even Apple count" in {
    (2 until 100 by 2).map { numberOfFruit =>
      SpecialOffersService.getFruitSubtotal(Apple, numberOfFruit) should be((numberOfFruit / 2) * PriceService.getPriceInPence(Apple))
    }
  }

  "getFruitSubtotal" should "return a two for 1 discount for odd Apple count (n - 1) plus 1" in {
    (1 until 99 by 2).map { numberOfFruit =>
      SpecialOffersService.getFruitSubtotal(Apple, numberOfFruit) should be(((numberOfFruit / 2) + 1) * PriceService.getPriceInPence(Apple))
    }
  }

  "getFruitSubtotal" should "return a simple addition for Orange count 2" in {
    SpecialOffersService.getFruitSubtotal(Orange, 2) should be(2 * PriceService.getPriceInPence(Orange))
  }

  "getFruitSubtotal" should "return a two for 1 discount for Orange count divisible by 3" in {
    (1 to 100).map { numberOfFruit =>
      val effectiveCount = (numberOfFruit / 3) * 2 + numberOfFruit % 3
      SpecialOffersService.getFruitSubtotal(Orange, numberOfFruit) should be(effectiveCount * PriceService.getPriceInPence(Orange))
    }
  }
}
