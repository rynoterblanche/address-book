package com.rt.addressbook

/**
  * Created by rt on 29/05/2017.
  */
object AddressBookApp extends App {

  val addressReader = new AddressCsvReader(getClass.getResource("/addressbook.csv").getFile)
  val addressService = new AddressService(addressReader)

  printf("Total number of males are %s\n", addressService.getCountByGender("Male"))

  val oldest = addressService.getOldest;
  printf("Oldest person is %s with an age of %s days\n", oldest.name, addressService.getAge(Some(oldest)))
  printf("Bill is %s days older than Paul\n", addressService.getAgeDiffByName("Paul Robinson", "Bill McKnight"))

}
