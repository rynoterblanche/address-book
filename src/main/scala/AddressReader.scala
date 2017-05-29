package com.rt.addressbook

trait AddressReader {

  def read(): Seq[Address]
}

case class Address (name: String, gender: String, birthDate: String)
