package com.rt.addressbook

class AddressService(val addressReader: AddressReader) {

  val addressList = addressReader.read()

  def getCountByGender(gender: String): Int = addressList.filter(_.gender == gender).size
}
