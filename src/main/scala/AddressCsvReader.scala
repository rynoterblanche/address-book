package com.rt.addressbook

import scala.io.Source

class AddressCsvReader(val fileName: String) extends AddressReader {

  override def read(): Seq[Address] = {
    for {
      line <- Source.fromFile(fileName).getLines().toVector
      values = line.split(",").map(_.trim)
    } yield Address(values(0), values(1), values(2))
  }
}
