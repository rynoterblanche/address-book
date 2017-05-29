package com.rt.addressbook

class AddressService(val addressReader: AddressReader) {

  val addressList = addressReader.read()

}
