object ManajemenInventory {
  def main(args: Array[String]): Unit = {
    val inventory = new Inventory // AMBIL CLASS DARI ITEM
    var running = true // UNTUK PROSES LOOPING

    while (running) {
      println("=== Sistem Manajemen Inventori ===")
      println("1. Tambah Barang\n2. Keluarkan Barang\n3. Lihat Inventori\n4. Keluar")
      print("Pilih menu: ")
      scala.io.StdIn.readLine() match {
        case "1" =>
          print("Nama barang: ");
          val nama = scala.io.StdIn.readLine()
          print("Jumlah: ");
          val jumlah = scala.io.StdIn.readInt()
          print("Harga: ");
          val harga = scala.io.StdIn.readDouble()
          inventory.tambahBarang(nama, jumlah, harga)
        case "2" =>
          print("Nama barang: ");
          val nama = scala.io.StdIn.readLine()
          print("Jumlah: ");
          val jumlah = scala.io.StdIn.readInt()
          inventory.keluarkanBarang(nama, jumlah)
        case "3" =>
          inventory.tampilkanInventori()
        case "4" =>
          println("Keluar...")
          running = false
        case _ =>
          println("Pilihan tidak valid.")
      }
    }
  }
}
