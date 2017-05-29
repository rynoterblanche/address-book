package com.rt.addressbook

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.Days

class AddressService(val addressReader: AddressReader) {

  val addressList = addressReader.read()
  val formatter = DateTimeFormat.forPattern("dd/MM/yy")

  def getCountByGender(gender: String): Int = addressList.filter(_.gender == gender).size

  def getOldest(): Address = addressList.reduceLeft(maxAge)

  def maxAge(a1: Address, a2: Address): Address = if (getAge(Some(a1)) > getAge(Some(a2))) a1 else a2

  def getAge(address: Option[Address]): Int = address match {
    case Some(address) => Days.daysBetween(formatter.parseDateTime(address.birthDate), DateTime.now()).getDays
    case None => 0
  }

  def getAddress(name: String): Option[Address] = addressList.find(_.name == name)

  def getAgeDiffByName(name1: String, name2: String): Int = getAgeDiffByAddress(getAddress(name1), getAddress(name2))

  def getAgeDiffByAddress(a1: Option[Address], a2: Option[Address]): Int = Math.abs(getAge(a1) - getAge(a2))

}
