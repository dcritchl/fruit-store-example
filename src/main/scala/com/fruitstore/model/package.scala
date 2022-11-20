package com.fruitstore

// we support only two types of fruit

package object model {
  sealed trait Fruit
  case object Apple extends Fruit
  case object Orange extends Fruit
}
