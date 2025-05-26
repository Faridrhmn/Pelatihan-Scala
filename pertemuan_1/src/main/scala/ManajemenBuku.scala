import scala.io.StdIn.readLine
import scala.collection.mutable.ArrayBuffer

object ManajemenBuku {
  def main(args: Array[String]): Unit = {
    val Judul = ArrayBuffer[String]()
    val Pengarang = ArrayBuffer[String]()
    var pilih: Int = 0

    while (pilih >= 1 && pilih <= 3 || pilih == 0) {
      println("\n=== Program Manajemen Buku ===")
      println("------------------------------")
      println("Pilihan menu: ")
      println("1. Tampil Buku")
      println("2. Tambah Buku")
      println("3. Hapus Buku")
      println("4. Keluar")
      print("Pilih : ")
      pilih = readLine().toInt

      pilih match {
        case 1 =>
          if (Judul.isEmpty) {
            println("Belum ada buku dalam daftar.")
          } else {
            for (i <- Judul.indices) {
              println(s"${i + 1}. ${Judul(i)} ~ Pengarang: ${Pengarang(i)}")
            }
          }

        case 2 =>
          print("Judul Buku : ")
          val judul = readLine()
          print("Pengarang  : ")
          val pengarang = readLine()
          Judul += judul
          Pengarang += pengarang
          println("Buku berhasil ditambahkan.")

        case 3 =>
          if (Judul.isEmpty) {
            println("Daftar buku kosong, tidak ada yang bisa dihapus.")
          } else {
            print("Masukkan judul buku yang akan dihapus : ")
            val hapus = readLine()
            val noIndex = Judul.indexOf(hapus)
            if (noIndex >= 0) {
              Judul.remove(noIndex)
              Pengarang.remove(noIndex)
              println("Buku berhasil dihapus.")
            } else {
              println("Judul buku tidak ditemukan.")
            }
          }

        case 4 =>
          println("Program Selesai!")

        case _ =>
          println("Inputan salah! [1/2/3/4]")
      }
    }
  }
}