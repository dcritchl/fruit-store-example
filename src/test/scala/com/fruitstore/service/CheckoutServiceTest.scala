package com.fruitstore.service

import com.fruitstore.model.{Apple, Orange}
import org.scalatest._
import flatspec._
import matchers._

class CheckoutServiceTest extends AnyFlatSpec with should.Matchers {
  "getBasketTotalPrice" should "return the Apple subtotal for a basket of only Apples" in {
    (0 to 100).map { count =>
      val basket = List.fill(count)(Apple)

      CheckoutService.getBasketTotalPrice(basket) should be(SpecialOffersService.getFruitSubtotal(Apple, count))
    }
  }

  "getBasketTotalPrice" should "return the Orange subtotal for a basket of only Oranges" in {
    (0 to 100).map { count =>
      val basket = List.fill(count)(Orange)

      CheckoutService.getBasketTotalPrice(basket) should be(SpecialOffersService.getFruitSubtotal(Orange, count))
    }
  }

  "getBasketTotalPrice" should "return the combined subtotal for a basket of Oranges and Apples" in {
    for {
      orangeCount <- 0 to 100
      appleCount <- 0 to 100
    } yield {
      val oranges = List.fill(orangeCount)(Orange)
      val apples = List.fill(appleCount)(Apple)
      val basket = oranges ++ apples

      CheckoutService.getBasketTotalPrice(basket) should be(
        SpecialOffersService.getFruitSubtotal(Orange, oranges.size) +
          SpecialOffersService.getFruitSubtotal(Apple, apples.size)
      )
    }
  }
}
