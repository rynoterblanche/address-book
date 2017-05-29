package com.rt.addressbook

import org.scalatest.Matchers._
import org.scalatest.FunSuite

class AddressServiceTests extends FunSuite {

  val addressReader = new AddressCsvReader(getClass.getResource("/addressbook.csv").getFile)
  val addressService = new AddressService(addressReader)

  test("get total number of males") {
    addressService.getCountByGender("Male") shouldBe 3
  }

  test("get oldest person") {
    addressService.getOldest() shouldBe Address("Wes Jackson", "Male", "14/08/74")
  }
}