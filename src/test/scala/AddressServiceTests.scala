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

  test("find correct days between two ages by name") {
    addressService.getAgeDiffByName("Paul Robinson", "Bill McKnight") shouldBe 2862
    addressService.getAgeDiffByName("Unknown", "Bill McKnight") shouldBe 14684 // Bill's age minus zero
    addressService.getAgeDiffByName("Unknown", "Unknown") shouldBe 0
  }

  test("find correct days between two ages by address") {
    val addrPaul = Address("Paul Robinson", "Male", "15/01/85")
    val addrBill = Address("Bill McKnight", "Male", "16/03/77")
    addressService.getAgeDiffByAddress(Some(addrPaul), Some(addrBill)) shouldBe 2862
    addressService.getAgeDiffByAddress(Some(addrBill), Some(addrPaul)) shouldBe 2862
  }
}