package com.rt.addressbook

import org.scalatest.FunSuite

class AddressCsvReaderTests extends FunSuite {

  test("loading address book to address seq") {
    val list = new AddressCsvReader(getClass.getResource("/addressbook.csv").getFile).read()

    list contains Address("Bill McKnight", "Male", "16/03/77")
    list contains Address("Gemma Lane", "Female", "20/11/91")
    list contains Address("Wes Jackson", "Male", "14/08/74")
  }
}